package com.krlelirnz.simpledbapp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Admin implements ActionListener {
  public static JFrame jFrame;
  public static Panel mainPanel, p1, p2, p3;
  public static Button logoutButton;
  DatabaseConnection jdbc;

  Admin(DatabaseConnection dbc) {
    jdbc = dbc;
    jFrame = new JFrame("Admin");
    jFrame.setSize(500, 300);
    jFrame.setResizable(false);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.setLocationRelativeTo(null);

    mainPanel = new Panel(new BorderLayout());
    Panel outp1 = new Panel(new GridLayout(2,1));
    p1 = new Panel();
    p1.add(new Label("Welcome Admin User!"));
    outp1.add(p1);
    outp1.add(new Panel());

    //Panel outp2 = new Panel(new GridLayout(3, 1));
    //outp2.add(new Panel());

    p2 = new Panel(new GridLayout(1, 4));
    p2.add(new Panel());
    p2.add(new Label("List of Users:"));

    try {
      DefaultListModel<String> uName = new DefaultListModel<>();
      ResultSet rs = jdbc.getAll();
      JList<String> usersList = new JList<String>();
      JScrollPane userList = new JScrollPane(usersList);
      while (rs.next()) {
        usersList.setModel(uName);
        uName.addElement(rs.getString("username"));
      }
      p2.add(userList);
      p2.add(new Panel());
      //outp2.add(p2);
      //outp2.add(new Panel());
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }

    Panel outp3 = new Panel(new GridLayout(3, 1));
    outp3.add(new Panel());
    p3 = new Panel();
    logoutButton = new Button("LogOut");
    p3.add(logoutButton);
    logoutButton.addActionListener(this);
    outp3.add(p3);
    outp3.add(new Panel());

    mainPanel.add(outp1, BorderLayout.NORTH);
    mainPanel.add(p2, BorderLayout.CENTER);
    mainPanel.add(outp3, BorderLayout.SOUTH);
    jFrame.add(mainPanel);
    jFrame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    jFrame.dispose();
    new Login();
  }
}
