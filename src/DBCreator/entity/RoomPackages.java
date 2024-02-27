/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBCreator.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "Room Packages")
public class RoomPackages {
    
    @Id
    @Column(name = "Room Type", length = 10)
    private String roomType;
    
    @Column(name = "Charge", nullable = false, columnDefinition = "DECIMAL(5,2)")
    private float charge;
    
    @Transient
    @OneToMany(mappedBy = "RoomPakages", targetEntity = PurchaseDetail.class)
    private List<PurchaseDetail> purchaseDetails;
    
    @Transient
    @OneToMany(mappedBy = "RoomPackages", targetEntity = RoomsData.class)
    private List<RoomsData> roomsDatas;
}
