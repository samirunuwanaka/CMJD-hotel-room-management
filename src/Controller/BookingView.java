/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.CRUD;
import Dto.RoomPackageDto;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class BookingView {

    public static RoomPackageDto[] getAllCharges() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static List<String> getUpcomingDates(String curDate, int numDates) {
        List<String> upcomingDates = new ArrayList<>();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(curDate, formatter);

            for (int i = 0; i < numDates; i++) {
                date = date.plusDays(1); // Increment by one day
                upcomingDates.add(date.format(formatter));
            }
        } catch (Exception e) {
            // Handle exceptions (e.g., invalid date format)
            e.printStackTrace();
        }
        return upcomingDates;
    }

    public static String[] tblRoomNo(String year, String month, String day, String noOfDays, String roomPackage) throws SQLException, ParseException {
        ResultSet resultSet = CRUD.getFromDataBase("Rooms Data", "Room No", "WWHERE Room Type = ", roomPackage);
        String[] roomNo = new String[0];
        while (resultSet.next()) {
            String[] tempRoomNo = new String[roomNo.length + 1];
            int i = 0;
            for (String string : roomNo) {
                tempRoomNo[i] = string;
                i++;
            }
            roomNo = tempRoomNo;
        }
        String dateAsString = day + "-"
                + getMonth(month) + "-"
                + year;

////////////////////////////////////////////////////////////
        String[] date = new String[Integer.parseInt(noOfDays)];
        date[0] = dateAsString;

        LocalDate startDate = LocalDate.parse(dateAsString, DateTimeFormatter.ISO_LOCAL_DATE);

        // Calculate and print the next 5 dates
        for (int i = 1; i <= Integer.parseInt(noOfDays); i++) {
            LocalDate nextDate = startDate.plusDays(i);
            date[i] = nextDate.toString();
        }
///////////////////////////////////////////////////////        
        for (String tempDate : date) {

            ResultSet purchased = CRUD.getFromDataBase("Purchase Detail", "Room No", "WWHERE Room Type = ", roomPackage, " && WHERE Date = ", tempDate);
            while (purchased.next()) {
                for (int i = 0; i < roomNo.length; i++) {
                    if (roomNo[i].equals(purchased.getString("Room No"))) {
                        String[] tempRoomNo = new String[roomNo.length - 1];
                        for (int j = 0; j < i; j++) {
                            tempRoomNo[j] = roomNo[j];
                        }
                        for (int j = i + 1; j < roomNo.length; j++) {
                            tempRoomNo[j] = roomNo[j];
                        }
                        roomNo = tempRoomNo;
                        i--;
                    }
                }
            }
        }
        return roomNo;
    }

    private static String getMonth(String month) {
        String[] monthOrder = {"January", "February", "March", "April", "May", "June", "July", "August", "Sepethember", "Octomber", "November", "December"};
        for (int i = 0; i < monthOrder.length; i++) {
            if (month.equalsIgnoreCase(monthOrder[i])) {
                if (i >= 10) {
                    return Integer.toString(i + 1);
                } else {
                    return "0" + Integer.toString(i + 1);
                }
            }
        }
        return null;
    }

    public static void tblPrevious(JTable table) throws SQLException {
        ResultSet resultSet = CRUD.getFromDataBase("Purchase Detail", "(Room Type, Dinning Package, Date, Room No)", "WHERE Room ID = ", getRoomIDByCustID(), " ORDER BY Date, Room Type, Room No");
        while (resultSet.next()) {
            Object[] prevBook = {
                resultSet.getString("Room Type"),
                resultSet.getString("Dinning Package"),
                resultSet.getString("Date"),
                resultSet.getString("Room No")
            };
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            dtm.addRow(prevBook);
        }
    }

    private static String getRoomIDByCustID() throws SQLException {
        String custID = Dto.LogInDto.getID();
        ResultSet resultSet = CRUD.getFromDataBase("Check In Dtata", "Room ID", "WHERE Cust ID = ", custID, " && Checked In = FALSE");
        String roomID = "";
        while (resultSet.next()) {
            roomID = roomID + resultSet.getString("Room ID") + " || WHERE Room ID = ";
        }
        roomID = roomID + "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
        return roomID;
    }

    public static boolean saveBooking(String custID, String roomPackage, String dinningPackage, String roomNo, int persons, int days, String date) throws SQLException {
        try {
            String time = CRUD.getSystemDateStringWithTime();
            CRUD.save("Purchase Data(Cust ID, Purchase Date)", custID, time);
            String roomID = CRUD.getFromDataBase("Purchae Data", "Room ID", "WHERE Cust ID = ", custID, " && WHERE Purchase Date = ", time).getString("Room ID");
            CRUD.save("Purchase Detail(Room Type, Date, Dinning Package, Room ID, Room No, No Of Person)", "(", roomPackage, date, dinningPackage, roomID, roomNo, String.valueOf(persons), ")");
            CRUD.save("Check In Data(Cust ID, Room ID, Checked In)", custID, roomID, "FALSE");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean tryDelete(String roomNo, String date) throws SQLException {
        return CRUD.delete(roomNo, date);
    }

}
