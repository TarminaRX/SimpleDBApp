package com.krlelirnz.simpledbapp;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login implements ActionListener {
  JFrame mFrame;
  JTextField t1;
  JButton b1;
  JLabel messE;
  JPasswordField p1;
  DatabaseConnection jdbc;
  String username;
  String password;
  private int logCount = 0;

  Login() {
    jdbc = new DatabaseConnection("test-sql.db");
    mFrame = new JFrame("User Login");
    mFrame.setSize(320, 180);
    mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mFrame.setLocationRelativeTo(null);
    mFrame.setResizable(true);

    Panel mainP = new Panel();
    Panel secPanel = new Panel(new GridLayout(2, 2));

    // Username panel
    Panel uName = new Panel();
    Panel uText = new Panel();
    uName.add(new Label("Username:"));
    uText.add(t1 = new JTextField(10));
    secPanel.add(uName);
    secPanel.add(uText);

    // Password panel
    Panel pName = new Panel();
    Panel pText = new Panel();
    pName.add(new Label("Password:"));
    pText.add(p1 = new JPasswordField(10));
    secPanel.add(pName);
    secPanel.add(pText);

    // Button
    Panel bton = new Panel();
    b1 = new JButton("Login");
    bton.add(b1);
    b1.addActionListener(this);

    // Error messsage
    Panel error = new Panel();
    messE = new JLabel("");
    error.add(messE);

    mainP.add(secPanel);
    mainP.add(bton);
    mainP.add(error);
    mFrame.add(mainP);
    mFrame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    username = t1.getText();
    password = new String(p1.getPassword());
    try {
      DatabaseConnection.User user = jdbc.getUser(username, password);
      openWindow(user);
    } catch (SQLException e1) {
      logCount++;
      if (logCount >= 3) {
        JOptionPane.showMessageDialog(mFrame, "Too many failed login attempts");
        System.exit(0);
      } else {
        messE.setText("Invalid Username or Password. Attempts Left: " +
                      (3 - logCount));
      }
    }
  }

  public void openWindow(DatabaseConnection.User user) {
    if ("admin".equals(user.getuser_role())) {
      new Admin();
      mFrame.dispose();
    } else {
      new Guest(username);
      mFrame.dispose();
    }
  }
}
