package com.krlelirnz.simpledbapp;

import java.sql.*;

public class DatabaseConnection {
    private Connection conn;

    public ResultSet getAll() throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("select * from Users");
    }


    public DatabaseConnection(String username, String password, String database) {
        String connStr = "jdbc:sqlite:resources/" + database;
        try {
            conn = DriverManager.getConnection(connStr);
        } catch (SQLException e) {
            System.err.println("Failed to create connection");
            System.err.println(e.toString());
        }
    }
}
