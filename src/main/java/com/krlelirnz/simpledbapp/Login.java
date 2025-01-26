package com.krlelirnz.simpledbapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Login implements ActionListener {
    JFrame mFrame; TextField t1, t2; JButton b1; 

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

        mainP.add(secPanel); mainP.add(bton);
        mFrame.add(mainP);
    }
    public void actionPerformed(ActionEvent e){
        String username = t1.getText();
        String password = t2.getText();
        DatabaseConnection jdbc = new DatabaseConnection("root", "root", "test-sql.db");
        try {
            jdbc.getUser(username, password);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

