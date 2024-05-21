import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class NewUser implements ActionListener{
    JFrame frame = new JFrame();
    JButton saveButton = new JButton("Save");
    JLabel newUserNameLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel ("Password");
    JTextField usernameField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    HashMap<String, String> logInInfo = new HashMap<String,String>();

    IDandPasswords idandPasswords = new IDandPasswords();
   
    
    NewUser(){
        newUserNameLabel.setBounds(50,100,75,25);
        passwordLabel.setBounds(50,150,75,25);

        usernameField.setBounds(125,100, 200,25);
        passwordField.setBounds(125,150, 200,25);

        saveButton.setBounds(125,200,100,25);
        saveButton.setFocusable(false);
        saveButton.addActionListener(this);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        frame.add(newUserNameLabel);
        frame.add(passwordField);
        frame.add(passwordLabel);
        frame.add(usernameField);
        frame.add(saveButton);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == saveButton){
            String userID = usernameField.getText();
            String password = String.copyValueOf(passwordField.getPassword());
            idandPasswords.setHashing(userID, password);
            idandPasswords.sendToFile();
            frame.dispose();
            LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());




        }
    }
}
