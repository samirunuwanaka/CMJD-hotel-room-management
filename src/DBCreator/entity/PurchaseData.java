/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBCreator.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "Purchase Data")
public class PurchaseData {
    
    @ManyToOne
    @JoinColumn(name = "Cust ID", nullable = false)
    private String custId;
    
    @Column(name = "Purchase Date", nullable = false, updatable = false, columnDefinition = "DATE")
    private Date purchaseDate;
    
    @OneToOne
    @JoinColumn(name = "Room ID", nullable = false, unique = true)
    private String roomId;
    
}
