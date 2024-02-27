/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author USER
 */
public class LogInView {

    public static String custLogIn(String txtUsername, String txtPassword) {
        return DAO.CRUD.getID("Admin Data", "Admin ID", "WHERE Username = ",txtUsername," && ",txtPassword);
    }

    public static String adminLogIn(String txtUsername, String txtPassword) {
        return DAO.CRUD.getID("Customer Data", "Cust ID", "WHERE Username = ",txtUsername," && ",txtPassword);
    }
    
}
