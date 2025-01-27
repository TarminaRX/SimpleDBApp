package com.krlelirnz.simpledbapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Login implements ActionListener {
    JFrame mFrame; TextField t1, t2; JButton b1; JLabel messE;
    private DatabaseConnection jdbc;
    private int logCount;

    Login(){
        mFrame = new JFrame("User Login");
        mFrame.setVisible(true);
        mFrame.setSize(300, 180);
        mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mFrame.setResizable(false);

        Panel mainP = new Panel();
        Panel secPanel = new Panel(new GridLayout(2, 2));

        //Username panel
        Panel uName = new Panel(); Panel uText = new Panel();
        uName.add(new Label("Username:")); 
        uText.add(t1 = new TextField(10));
        secPanel.add(uName); secPanel.add(uText);

        //Password panel
        Panel pName = new Panel(); Panel pText = new Panel();
        pName.add(new Label("Password:"));
        pText.add(t2 = new TextField(10));
        secPanel.add(pName); secPanel.add(pText);
        

        //Button
        Panel bton = new Panel();
        b1 = new JButton("Login");
        bton.add(b1);
        b1.addActionListener(this);

        mainP.add(secPanel); mainP.add(bton); mainP.add(messE);
        mFrame.add(mainP);
    }
    public void actionPerformed(ActionEvent e){
        String username = t1.getText();
        String password = t2.getText();
        jdbc = new DatabaseConnection("root", "root", "test-sql.db");
        try {
            DatabaseConnection.User user = jdbc.getUser(username, password);
            if(user != null){
                logCount = 0;
                openWindow(user);
            } else{
                logCount++;
                if(logCount >= 3){
                    JOptionPane.showMessageDialog(mFrame, "Too many failed login attempts");
                    System.exit(0);
                }
                messE.setText("Invalid Username or Password. Attempts Left: " + logCount);
            }
        } catch (SQLException e1) {
            messE.setText("Database connection failed" + e1.getMessage());
        }
    }

    public void openWindow(DatabaseConnection.User user){
        if ("admin".equals(user.getuser_role())){
            new Admin();
        }
        else{
            new Guest();
        }
    }
}

