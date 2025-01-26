package com.krlelirnz.simpledbapp;
import java.awt.*;
import javax.swing.*;


import java.awt.event.ActionListener;

public class Admin{
        public static JFrame jFrame;
        public static Panel mainPanel, p1, p2, p3;
        public static Button logoutButton;
    Admin(){
        jFrame = new JFrame("Admin");
        jFrame.setSize(500,500);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        mainPanel = new Panel(new GridLayout(3,1));
        p1 = new Panel();
        p1.add(new Label("Welcome Admin User!"));
        
        p2 = new Panel();
        p2.add(new Label("List of Users:"));
        String [] users = {"UserExample1", "UserExample2"};
        JList<String> usersList = new JList<>(users);
        JScrollPane userList = new JScrollPane(usersList);
        p2.add(userList);

        p3 = new Panel();
        logoutButton = new Button("LogOut");
        p3.add(logoutButton);


        mainPanel.add(p1);
        mainPanel.add(p2);
        mainPanel.add(p3);
        jFrame.add(mainPanel);

        /** ActionListener logout = (ActionEvent) -> {
            
        }

        logoutButton.addActionListener(logout);
        
        */
        jFrame.setVisible(true);
    }
}