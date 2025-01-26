/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.krlelirnz.simpledbapp;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class SimpleDBApp {

    public static void main(String[] args) {
        // DatabaseConnection jdbc = new DatabaseConnection("root", "root", "test-sql.db");
        // try {
        //     ResultSet rs = jdbc.getAll();
        //     while(rs.next()) {
        //         System.out.println(rs.getString("username") + rs.getString("password"));
        //     }
        // } catch (SQLException e) {
        //     System.err.println(e.toString());
        //     System.err.println("");
        // }
        //  System.out.println("Working Directory = " + System.getProperty("user.dir"));
        
        Login log = new Login();
        }
}
