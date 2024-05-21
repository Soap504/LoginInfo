import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoginPage implements ActionListener{

    

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton registerButton = new JButton("Register");
    JTextField useridField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("UserID:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel message = new JLabel();

    
    
    HashMap<String, String> logInInfo = new HashMap<String,String>();


    LoginPage(HashMap<String,String> OriginalLoginInfo){
        logInInfo = OriginalLoginInfo;

        userIDLabel.setBounds(50,100,75,25);
        passwordLabel.setBounds(50,150,75,25);

        message.setBounds(125,250,250,35);
        message.setFont(new Font(null, Font.ITALIC,25));

        useridField.setBounds(125,100, 200,25);
        passwordField.setBounds(125,150, 200,25);

        loginButton.setBounds(50,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(125,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        registerButton.setBounds(225,200,100,25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);


        frame.add(registerButton);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.add(useridField);
        frame.add(passwordField);
        frame.add(message);
        frame.add(userIDLabel);
        frame.add(passwordLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == resetButton){
            useridField.setText("");
            passwordField.setText("");
        }
        if(e.getSource() == loginButton){
            String userID = useridField.getText();
            String password = String.copyValueOf(passwordField.getPassword());

            if(logInInfo.containsKey(userID)){
                if(logInInfo.get(userID).equals(password)){
                    message.setForeground(Color.green);
                    message.setText("Login succesful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
                    
                }
                else{
                    message.setForeground(Color.red);
                    message.setText("Wrong password");
                }
            }
            else{
                message.setForeground(Color.red);
                message.setText("username not found");
            }

        }
        if(e.getSource() == registerButton){
            frame.dispose();
            NewUser newUser = new NewUser();
        }
    }
        
}
