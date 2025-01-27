package com.krlelirnz.simpledbapp;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Admin implements ActionListener{
        public static JFrame jFrame;
        public static Panel mainPanel, p1, p2, p3;
        public static Button logoutButton;
        DatabaseConnection jdbc;
  
    Admin(){
        jdbc = new DatabaseConnection("test-sql.db");
        jFrame = new JFrame("Admin");
        jFrame.setSize(500,500);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
       

        mainPanel = new Panel(new GridLayout(3,1));
        p1 = new Panel();
        p1.add(new Label("Welcome Admin User!"));
        
        p2 = new Panel();
        p2.add(new Label("List of Users:"));
       
        try{
            DefaultListModel<String> uName = new DefaultListModel<>();
            ResultSet rs = jdbc.getAll();
            while(rs.next()){
                uName.addElement(rs.getString("username"));
            }
            JList<String> usersList = new JList<String>(uName);
            JScrollPane userList = new JScrollPane(usersList);
            p2.add(userList);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

        p3 = new Panel();
        logoutButton = new Button("LogOut");
        p3.add(logoutButton);
        logoutButton.addActionListener(this);

        mainPanel.add(p1);
        mainPanel.add(p2);
        mainPanel.add(p3);
        jFrame.add(mainPanel);
        jFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        new Login(); jFrame.dispose();
    }
}