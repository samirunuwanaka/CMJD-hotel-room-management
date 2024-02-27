/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CRUD;
import Dto.CheckInDto;
import Dto.PurchaseRoomsDto;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class CheckInView {

    public static String[] getTblCustPurcaseRowNames() {
        String[] columns = {"Room ID","Room Type","Dinning Package","Room No", "Floor No","Room Date", "Checked In"};
        return columns;
    }

    public static Object[] getTblCustPurcaseRowData(PurchaseRoomsDto dto) {
        Object[] rowData = {
            dto.getRoomId(),
            dto.getRoomType(),
            dto.getDinningPackage(),
            dto.getRoomNo(),
            dto.getFloorNo(),
            dto.getRoomDate(),
            dto.getIsIsCheckedIn()
        };
        return rowData;
    }

    public static PurchaseRoomsDto[] getAllpurchases(String IDCardNo, String aditional) throws SQLException {
        ResultSet resultSet = CRUD.getFromDataBase("Check In Data", "*", "WHERE Cust ID =",getIDOfCust( IDCardNo),aditional);
        PurchaseRoomsDto[] purchaseRoomsDtos = new PurchaseRoomsDto[0];
        while(resultSet.next()){
            PurchaseRoomsDto[] tempPurchaseRoomsDtos = new PurchaseRoomsDto[purchaseRoomsDtos.length+1];
            int i =0;
            for(PurchaseRoomsDto purchaseRoomsDto: purchaseRoomsDtos){
                tempPurchaseRoomsDtos[i] = purchaseRoomsDto;
                i++;
            }
            tempPurchaseRoomsDtos[purchaseRoomsDtos.length] = new PurchaseRoomsDto(resultSet.getString("Room ID"),
                    CRUD.getFromDataBase("Purchase Detail", "(Room Type)", "WHERE Room ID =",resultSet.getString("Room ID")).getString("Room Type"),
                    CRUD.getFromDataBase("Purchase Detail", "(Dinning Package)", "WHERE Room ID =",resultSet.getString("Room ID")).getString("Dinning Package"),
                    CRUD.getFromDataBase("Purchase Detail", "(Room No)", "WHERE Room ID =",resultSet.getString("Room ID")).getString("Room No"),
                    CRUD.getFromDataBase("Rooms Data", "(Floor No)", "WHERE room No = ",(CRUD.getFromDataBase("Purchase Detail", "(Room No)", "WHERE Room ID =",resultSet.getString("Room ID")).getString("Room No"))).getInt("floor No"),
                    CRUD.getFromDataBase("Purchase Detail", "(Date)", "WHERE Room ID =",resultSet.getString("Room ID")).getDate("Date"),
                    resultSet.getBoolean("Checked In")
                    );
            purchaseRoomsDtos = tempPurchaseRoomsDtos;
        }
        return purchaseRoomsDtos;
    }

    public static void getCheckInDto(String roomId, String string) throws SQLException {
        ResultSet resultSetCheckInData = CRUD.getFromDataBase("Check In Data", "*", "WHERE Room ID = ", roomId);
        ResultSet resultSetPurchaseDetail = CRUD.getFromDataBase("Purchase Detail", "*", "WHERE Room ID = ", roomId);
        ResultSet resultSetPurchaseData = CRUD.getFromDataBase("Purchase Data", "*", "WHERE Room ID = ", roomId);
        Dto.CheckInDto.checkInDtoReset(resultSetPurchaseDetail.getInt("No Of Person"), 
                resultSetPurchaseData.getDate("Purchase Date"), 
                CRUD.getFromDataBase("Customer Data", "Name", "WHERE Cust ID = ", resultSetCheckInData.getString("Cust ID")).getString("Name"), 
                resultSetPurchaseDetail.getDate("Date"), 
                resultSetPurchaseDetail.getString("Room Type"), 
                resultSetPurchaseDetail.getString("Dinning Package"), 
                roomId, 
                resultSetPurchaseDetail.getString("Room No"), 
                CRUD.getFromDataBase("Rooms Data", "Foor No", "WHERE Room No = ", resultSetPurchaseDetail.getString("Room No")).getInt("Floor No"),
                resultSetCheckInData.getBoolean("Checked In"));
        return;
    }

    public static String getIDOfCust(String IDCardNo) {
        return CRUD.getID("Customer Data", "Cust ID", "WHERE ID = ", IDCardNo);
    }
    
}