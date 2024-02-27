/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

import Controller.CheckInView;
import java.util.Date;

/**
 *
 * @author USER
 */
public class PurchaseRoomsDto {
//            String[] columns = {"Room ID","Room Type","Dinning Package","Room No", "Floor No","Room Date", "Checked In"};

    private String roomId;
    private String roomType;
    private String dinningPackage;
    private String roomNo;
    private int floorNo;
    private Date roomDate;
    private boolean isCheckedIn;

    /**
     * @return the roomId
     */
    public String getRoomId() {
        return roomId;
    }

    /**
     * @param roomId the roomId to set
     */
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    /**
     * @return the roomType
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * @param roomType the roomType to set
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * @return the dinningPackage
     */
    public String getDinningPackage() {
        return dinningPackage;
    }

    /**
     * @param dinningPackage the dinningPackage to set
     */
    public void setDinningPackage(String dinningPackage) {
        this.dinningPackage = dinningPackage;
    }

    /**
     * @return the roomNo
     */
    public String getRoomNo() {
        return roomNo;
    }

    /**
     * @param roomNo the roomNo to set
     */
    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    /**
     * @return the floorNo
     */
    public int getFloorNo() {
        return floorNo;
    }

    /**
     * @param floorNo the floorNo to set
     */
    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    /**
     * @return the roomDate
     */
    public Date getRoomDate() {
        return roomDate;
    }

    /**
     * @param roomDate the roomDate to set
     */
    public void setRoomDate(Date roomDate) {
        this.roomDate = roomDate;
    }

    /**
     * @return the isCheckedIn
     */
    public boolean getIsIsCheckedIn() {
        return isCheckedIn;
    }

    /**
     * @param isCheckedIn the isCheckedIn to set
     */
    public void setIsCheckedIn(boolean isCheckedIn) {
        this.isCheckedIn = isCheckedIn;
    }

    public PurchaseRoomsDto(String roomId, String roomTypr, String dinningPackage, String roomNo, int floorNo, Date roomDate, boolean isCheckedIn) {
        this.roomId = roomId;
        this.roomType = roomTypr;
        this.dinningPackage = dinningPackage;
        this.roomNo = roomNo;
        this.floorNo = floorNo;
        this.roomDate = roomDate;
        this.isCheckedIn = isCheckedIn;
    }

}
