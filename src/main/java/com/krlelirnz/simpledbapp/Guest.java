package com.krlelirnz.simpledbapp;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Guest {
    public static JFrame jFrame;
    public static Panel mainPanel, p1, p2;
    public static Button logoutButton;

    Guest(){
        jFrame = new JFrame("Guest ");
        jFrame.setSize(500,500);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new Panel(new GridLayout(2,1));
        p1 = new Panel();
        p1.add(new Label("Welcome Guest User!"));

        p2 = new Panel();
        logoutButton = new Button("LogOut");
        p2.add(logoutButton);

        mainPanel.add(p1);
        mainPanel.add(p2);

        jFrame.add(mainPanel);

        /** ActionListener logout = (ActionEvent) -> {
            
        }

        logoutButton.addActionListener(logout);
        
        */
    }
}
