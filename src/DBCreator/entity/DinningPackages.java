/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBCreator.entity;

import java.util.List;
import javax.persistence.CascadeType;
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
@Table(name = "Dinning Packages")
public class DinningPackages {
    
    @Id
    @Column(name = "Dinning Pakage", nullable = false, length = 15)
    private String dinningPakage;
    
    @Column(name = "Charge", columnDefinition = "DECIMAL(5,2)")
    private float charge;
    
    @Transient()
    @OneToMany(mappedBy = "DinningPackages", targetEntity = PurchaseDetail.class)
    private List<PurchaseDetail> purchaseDetails;
    
}
