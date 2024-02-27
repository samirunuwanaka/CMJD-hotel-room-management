/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DBConnection.DBConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class CRUD {

    private static String date = "dd-MM-yyyy";
    private static String dateWithTime = "dd-MM-yyyy HH:mm:ss";

    private static PreparedStatement getPreparedStatement(String sql, Object... args) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
        }
        return preparedStatement;
    }

    public static boolean update(String table, String columnsData, String... args) throws SQLException {
        String sql = "UPDATE ? SET ? ?";
        return getPreparedStatement(sql, table, columnsData, args).executeUpdate() > 0;
    }

    public static boolean save(String tableColumns, String... args) throws SQLException {
        String sql = "INSER INTO ? VALUES ?";
        return getPreparedStatement(sql, tableColumns, args).executeUpdate() > 0;
    }

    public static String getID(String table, String idColumn, String... args) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static boolean delete(String roomNo, String date) throws SQLException {
        String roomId = getFromDataBase("Purchase Detail", "Room ID", "WHERE Room No = ", roomNo, " && WHERE Date = ", date).getString("Room ID");
        String sql = "DELETE FROM ? WHERE Room ID= ?";
        if(getPreparedStatement(sql, "Purchase Data", roomId).executeUpdate()>0)
            return getPreparedStatement(sql, "Check In Data", roomId).executeUpdate()>0;
        return false;
    }

    public static ResultSet getFromDataBase(String table, String columns, String... whereState) throws SQLException {
        String sql = "SELECT ? FROM ? ?";
        return getPreparedStatement(sql, columns, table, whereState).executeQuery();
    }

    public static String getSystemDateString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CRUD.date);
        return dateFormat.format(new Date());
    }

    public static String getSystemDateStringWithTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CRUD.dateWithTime);
        return dateFormat.format(new Date());
    }

    public static Date getSystemDateDate() {
        return new Date();
    }

    public static Date getSystemDateStringToDate(String getDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CRUD.date);
        return dateFormat.parse(getDate);
    }

    public static Date getSystemDateStringToWithTime(String getDate) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(CRUD.dateWithTime);
        return dateFormat.parse(getDate);
    }

}
