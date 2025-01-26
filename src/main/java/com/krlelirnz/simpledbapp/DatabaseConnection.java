package com.krlelirnz.simpledbapp;

import java.sql.*;

public class DatabaseConnection {
    private Connection conn;
    String usname; String pass;

    public ResultSet getAll() throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("select * from Users");
    }

    public User getUser(String username, String password) throws SQLException {
        Statement stmt = conn.createStatement();
        String sqlStr = "select * from Users where username=" +
                username + " & password=" + password;
        ResultSet rs = stmt.executeQuery(sqlStr);
        if(rs.next())
            return new User(rs.getString("username"), rs.getString("password"),
                rs.getString("user_role"));
        else return null;
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

    public class User {
        String username;
        String password;
        String user_role;

        public User(String username, String password, String user_role) {
            this.username = username;
            this.password = password;
            this.user_role = user_role;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getuser_role() {
            return user_role;
        }

        public void setuser_role(String user_role) {
            this.user_role = user_role;
        }
    }
}
