/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DBCreator;

import DBConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DBCreatorMySQLCode {

    private static boolean createDBifNotExists(String sql) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // Set any necessary parameters for your SQL statement
            // For example:
            // preparedStatement.setString(1, "some_value");
            // preparedStatement.setInt(2, 42);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check if any rows were affected (inserted/updated/deleted)
            return rowsAffected > 0;
        }
    }

    public static void createDBifNotExists() throws SQLException {
        if (createDBifNotExists("CREATE DATABASE IF NOT EXISTS hotelRoomManagement")) {
            createDBifNotExists("CREATE TABLE `Admin Data` (\n"
                    + "    `Admin Id` INT AUTO_INCREMENT PRIMARY KEY,\n"
                    + "    `Name` VARCHAR(20) NOT NULL,\n"
                    + "    `Username` VARCHAR(15) NOT NULL,\n"
                    + "    `Password` VARCHAR(15) NOT NULL\n"
                    + ");");
            createDBifNotExists("CREATE TABLE `Customer_Data` (\n"
                    + "  `Cust_ID` INT AUTO_INCREMENT PRIMARY KEY,\n"
                    + "  `Name` VARCHAR(20) NOT NULL,\n"
                    + "  `ID` VARCHAR(12) NOT NULL UNIQUE,\n"
                    + "  `Phone_Number` INT NOT NULL,\n"
                    + "  `Address` VARCHAR(30) NOT NULL,\n"
                    + "  `Username` VARCHAR(15) NOT NULL UNIQUE,\n"
                    + "  `Password` VARCHAR(15) NOT NULL\n"
                    + ");");
            createDBifNotExists("CREATE TABLE `Purchase_Data` (\n"
                    + "  `Purchase_Date` DATE NOT NULL,\n"
                    + "  `Room_ID` AUTO_INCREMENT VARCHAR(255) UNIQUE,\n"
                    + "  PRIMARY KEY (`Room_ID`),\n"
                    + " FOREIGN KEY (Cust_ID) REFERENCES Customer Data (Cust_ID)\n"
                    + ");");
            createDBifNotExists("CREATE TABLE `Check_In_Data` (\n"
                    + "  `DataInsertID` INT AUTO_INCREMENT PRIMARY KEY,\n"
                    + "  `Checked_In` BOOLEAN DEFAULT FALSE NOT NULL,\n"
                    + " FOREIGN KEY (Room ID) REFERENCES Purchase_Data (Room ID),\n"
                    + " FOREIGN KEY (Cust_ID) REFERENCES Customer Data (Cust_ID),\n"
                    + " FOREIGN KEY (Admin Id) REFERENCES Admin Data (Admin Id),\n"
                    + ");");
            createDBifNotExists("CREATE TABLE `Dinning Packages` (\n"
                    + "  `Dinning Pakage` VARCHAR(15) NOT NULL,\n"
                    + "  `Charge` DECIMAL(5,2),\n"
                    + "  PRIMARY KEY (`Dinning Pakage`)\n"
                    + ");");
            createDBifNotExists("CREATE TABLE `Room_Packages` (\n"
                    + "  `Room_Type` VARCHAR(10) NOT NULL,\n"
                    + "  `Charge` DECIMAL(5,2) NOT NULL,\n"
                    + "  PRIMARY KEY (`Room Type`)\n"
                    + ");");
            createDBifNotExists("CREATE TABLE `Rooms_Data` (\n"
                    + "  `Room_No` VARCHAR(5) NOT NULL,\n"
                    + "  `Floor_No` INT NOT NULL,\n"
                    + "  PRIMARY KEY (`Room No`),\n"
                    + " FOREIGN KEY (Room Type) REFERENCES Dinning Packages (Room Type)\n"
                    + ");");
            createDBifNotExists("CREATE TABLE `Purchase_Detail` (\n"
                    + "  `Room_Type` VARCHAR(255) NOT NULL,\n"
                    + "  `Date` DATE NOT NULL,\n"
                    + "  `Dinning_Package` VARCHAR(255) NOT NULL,\n"
                    + "  `No_Of_Person` INT NOT NULL,\n"
                    + "  PRIMARY KEY (`Room_ID`)\n"
                    + " FOREIGN KEY (Room ID) REFERENCES Purchase_Data (Room ID)\n"
                    + " FOREIGN KEY (Dinning Package) REFERENCES Purchase Data (Dinning Package)\n"
                    + " FOREIGN KEY (Room Type) REFERENCES Dinning Packages (Room Type)\n"
                    + " FOREIGN KEY (Room No) REFERENCES Rooms_Data (Room No)\n"
                    + ");");
        }
    }
}
