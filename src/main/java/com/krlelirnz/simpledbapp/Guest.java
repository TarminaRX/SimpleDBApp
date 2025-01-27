package com.krlelirnz.simpledbapp;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Guest implements ActionListener{
    public static JFrame jFrame;
    public static Panel mainPanel, p1, p2;
    public static Button logoutButton;

    Guest(String username){
        jFrame = new JFrame("Guest ");
        jFrame.setSize(500,300);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        mainPanel = new Panel(new GridLayout(3,1));
        Panel outerPanel = new Panel(new GridLayout(3,1));
        p1 = new Panel();
        p1.add(new Label("Welcome Guest " + username + "!"));

        p2 = new Panel();
        logoutButton = new Button("LogOut");
        p2.add(logoutButton);
        logoutButton.addActionListener(this);
        
        outerPanel.add(p1);
        outerPanel.add(p2);

        mainPanel.add(new Panel());
        mainPanel.add(outerPanel);
        mainPanel.add(new Panel());
        

        jFrame.add(mainPanel);


    }

    public void actionPerformed(ActiveEvent e){

    }

    public void actionPerformed(ActionEvent e) {
        new Login(); jFrame.dispose();
    }
}
