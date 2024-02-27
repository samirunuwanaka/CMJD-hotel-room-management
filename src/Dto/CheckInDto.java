/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

import DAO.CRUD;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author USER
 */
public class CheckInDto {
    private static int noOfPerson;
    private static Date purchaseDate;
    private static String custName;
    private static Date roomDate;
    private static String roomType;
    private static String dinningPackage;
    private static String roomId;
    private static String roomNo;
    private static int floorNo;
    private static boolean isCheckedIn;

    public static void checkInDtoReset(int noOfPerson, Date purchaseDate, String custName, Date roomDate, String roomType, String dinningPackage, String roomId, String roomNo, int floorNo,boolean isCheckedIn) {
        CheckInDto.noOfPerson = noOfPerson;
        CheckInDto.purchaseDate = purchaseDate;
        CheckInDto.custName = custName;
        CheckInDto.roomDate = roomDate;
        CheckInDto.roomType = roomType;
        CheckInDto.dinningPackage = dinningPackage;
        CheckInDto.roomId = roomId;
        CheckInDto.roomNo = roomNo;
        CheckInDto.floorNo = floorNo;
        CheckInDto.isCheckedIn = isCheckedIn;
    }

    public static void setCustName(String custName) throws ParseException {
        reset();
        CheckInDto.custName = custName;
    }

    public static int getNoOfPerson() {
        return noOfPerson;
    }

    public static Date getPurchaseDate() {
        return purchaseDate;
    }

    public static String getCustName() {
        return custName;
    }

    public static Date getRoomDate() {
        return roomDate;
    }

    public static String getRoomType() {
        return roomType;
    }

    public static String getDinningPackage() {
        return dinningPackage;
    }

    public static String getRoomId() {
        return roomId;
    }

    public static String getRoomNo() {
        return roomNo;
    }

    public static int getFloorNo() {
        return floorNo;
    }

    public static boolean isCheckedIn() {
        return isCheckedIn;
    }

    public static void setIsCheckedIn(boolean isCheckedIn) {
        CheckInDto.isCheckedIn = isCheckedIn;
    }
    
    public static void reset() throws ParseException{
        checkInDtoReset(0,CRUD.getSystemDateStringToDate(""),"",CRUD.getSystemDateStringToDate(""),"","","","",0,true);
    }
}
