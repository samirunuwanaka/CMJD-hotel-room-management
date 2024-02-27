/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBCreator.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "Purchase Detail")
public class PurchaseDetail {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Room Type", nullable = false)
    private String roomType;
    
    @Column(name = "Date", nullable = false, columnDefinition = "DATE")
    private Date date;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Dinning Package", nullable = false)
    private String diningPackage;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Room ID", updatable = false)
    private String roomId;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Room No", nullable = false)
    private String roomNo;
    
    @Column(name = "No Of Person", nullable = false)
    private int noOfPerson;
    
    @Transient
    @OneToOne(mappedBy = "PurchaseDetail", targetEntity = CheckInData.class)
    private List<CheckInData> checkInDatas;
}
