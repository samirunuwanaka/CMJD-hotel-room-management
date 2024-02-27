/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBCreator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "Rooms Data")
public class RoomsData {
    
    @Id
    @Column(name = "Room No", length = 5)
    private String roomNo;
    
    @ManyToOne
    @JoinColumn(name = "Room Type", nullable = false)
    private String roomType;
    
    @Column(name = "Floor No", nullable = false)
    private int floorNo;
    
}
