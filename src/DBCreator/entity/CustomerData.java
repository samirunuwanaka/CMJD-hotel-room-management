/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBCreator.entity;

import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "Customer Data")
public class CustomerData {
    
    @Column(name = "Name", nullable = false, length = 20)
    private String name;
    
    @Column(name = "ID", nullable = false, length = 12, unique = true)
    private String id;
    
    @Column(name = "Phone Number", nullable = false)
    private int phoneNo;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cust ID")
    private String csutId;
    
    @Column(name = "Address", length = 30, nullable = false, updatable = true)
    private String address;
    
    @Column(name = "Username", length = 15, nullable = false, unique = true)
    private String username;
    
    @Column(name = "Password", nullable = false, length = 15)
    private String password;
    
    @Transient
    @OneToMany(mappedBy = "CustomerData", targetEntity = PurchaseData.class)
    private List<PurchaseData> purchaseData;
    
    @Transient
    @OneToMany(mappedBy = "CustomerData", targetEntity = CheckInData.class)
    private List<CheckInData> checkInDatas;
}
