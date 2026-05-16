import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginGUI extends JFrame implements ActionListener {

    JLabel userLabel, passLabel;

    JTextField userField;

    JPasswordField passField;

    JButton loginButton;

    StudentDAO dao = new StudentDAO();

    LoginGUI() {

        setTitle("Admin Login");

        setSize(400, 250);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userLabel = new JLabel("Username:");

        userLabel.setBounds(50, 50, 100, 30);

        add(userLabel);

        userField = new JTextField();

        userField.setBounds(150, 50, 150, 30);

        add(userField);

        passLabel = new JLabel("Password:");

        passLabel.setBounds(50, 100, 100, 30);

        add(passLabel);

        passField = new JPasswordField();

        passField.setBounds(150, 100, 150, 30);

        add(passField);

        loginButton = new JButton("Login");

        loginButton.setBounds(150, 150, 100, 30);

        loginButton.addActionListener(this);

        add(loginButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        String username = userField.getText();

        String password =
                new String(passField.getPassword());

        boolean login =
                dao.adminLogin(username, password);

        if (login) {

            JOptionPane.showMessageDialog(
                    this,
                    "Login Successful"
            );

            new DashboardGUI();

            dispose();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Credentials"
            );
        }
    }

    public static void main(String[] args) {

        new LoginGUI();
    }
}