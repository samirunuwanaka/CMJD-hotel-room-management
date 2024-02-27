/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBCreator.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 *
 * @author USER
 */

@Entity
@Table(name = "Admin Data")

public class AdminData {
    
    @Column(name = "Name", nullable = false, length = 20)
    private String name;
    
    @Column(name = "Username", nullable = false, length = 15)
    private String userName;
    
    @Column(name = "Password", nullable = false, length = 15)
    private String password;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Admin Id", insertable = false)
    private String adminId;
    
    @Transient
    @OneToMany(mappedBy = "AdminData", targetEntity = CheckInData.class)
    List<CheckInData> checkInDatas;
}
