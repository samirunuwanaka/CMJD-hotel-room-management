/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author USER
 */
public class RoomPackageDto {
    private String roomType;
    private float roomChargeh;
    
    private String dinningPackage;
    private float dinningCharge;

    public RoomPackageDto(String roomType, float roomChargeh, String dinningPackage, float dinningCharge) {
        this.roomType = roomType;
        this.roomChargeh = roomChargeh;
        this.dinningPackage = dinningPackage;
        this.dinningCharge = dinningCharge;
    }

    public String getRoomType() {
        return roomType;
    }

    public float getRoomChargeh() {
        return roomChargeh;
    }

    public String getDinningPackage() {
        return dinningPackage;
    }

    public float getDinningCharge() {
        return dinningCharge;
    }
    
}
