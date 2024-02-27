/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBCreator.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "Check In Data")
public class CheckInData {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cust ID", nullable = false)
    private String custId;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DataInsertID", insertable = false)
    private String id;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Room ID", nullable = false)
    private String roomId;
    
    @Column(name = "Checked In", nullable = false, columnDefinition = "boolean default false")
    private boolean isCheckedIn;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Admin ID")
    private String adminId;
}
