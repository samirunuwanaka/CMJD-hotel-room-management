/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotelRoomManagementSystems;

import DBCreator.DBCreatorMySQLCode;
import DBCreator.SessionFactoryConfiguration;
import View.CheckInView;
import View.LogInView;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class HotelRoomManagementSystems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            try {
                SessionFactoryConfiguration.getInstance();
            } catch (Exception e) {
                DBCreatorMySQLCode.createDBifNotExists();
            }
//            new CheckInView().setVisible(true);
//            new View.BookingView().setVisible(true);
        } catch (Exception e) {
            Logger.getLogger(HotelRoomManagementSystems.class.getName()).log(Level.SEVERE, null, e);

        }
            new LogInView().setVisible(true);

// TODO code application logic here
    }

}
