// DashboardGUI.java
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class DashboardGUI extends JFrame
        implements ActionListener {

    JButton addButton;
    JButton viewButton;
    JButton searchButton;
    JButton updateButton;
    JButton deleteButton;
    JButton logoutButton;
    JLabel countLabel;
    JButton exportButton;

    DashboardGUI() {

        setTitle("Student Result Management System");

        setSize(500, 750);

        setLayout(null);

        getContentPane().setBackground(
                new Color(240, 248, 255)
        );

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Heading

        JLabel heading =
                new JLabel(
                        "STUDENT RESULT MANAGEMENT SYSTEM"
                );

        heading.setBounds(40, 10, 450, 40);

        heading.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        add(heading);

        // Add Student Button

        addButton =
                new JButton("Add Student");

        addButton.setBounds(150, 80, 180, 40);

        addButton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        addButton.addActionListener(this);

        add(addButton);

        // View Students Button

        viewButton =
                new JButton("View Students");

        viewButton.setBounds(150, 150, 180, 40);

        viewButton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        viewButton.addActionListener(this);

        add(viewButton);

        // Search Student Button

        searchButton =
                new JButton("Search Student");

        searchButton.setBounds(150, 220, 180, 40);

        searchButton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        searchButton.addActionListener(this);

        add(searchButton);

        // Update Student Button

        updateButton =
                new JButton("Update Student");

        updateButton.setBounds(150, 290, 180, 40);

        updateButton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        updateButton.addActionListener(this);

        add(updateButton);

        // Delete Student Button

        deleteButton =
                new JButton("Delete Student");

        deleteButton.setBounds(150, 360, 180, 40);

        deleteButton.setFont(
                new Font("Arial", Font.BOLD, 16)
        );

        deleteButton.addActionListener(this);

        add(deleteButton);

        // Center Window

        setLocationRelativeTo(null);

        setVisible(true);
        logoutButton =
        new JButton("Logout");

logoutButton.setBounds(150, 430, 180, 40);

logoutButton.setFont(
        new Font("Arial", Font.BOLD, 16)
);

logoutButton.addActionListener(this);

add(logoutButton);

countLabel =
        new JLabel();

countLabel.setBounds(160, 50, 250, 30);

countLabel.setFont(
        new Font("Arial", Font.BOLD, 16)
);

add(countLabel);

loadStudentCount();
exportButton =
        new JButton("Export PDF");

exportButton.setBounds(150, 530, 180, 40);

exportButton.setFont(
        new Font("Arial", Font.BOLD, 16)
);

exportButton.addActionListener(this);

add(exportButton);
    }

    public void actionPerformed(ActionEvent e) {

    if (e.getSource() == addButton) {

        new AddStudentGUI();
    }

    if (e.getSource() == viewButton) {

        new ViewStudentsGUI();
    }

    if (e.getSource() == searchButton) {

        new SearchStudentGUI();
    }

    if (e.getSource() == updateButton) {

        new UpdateStudentGUI();
    }

    if (e.getSource() == deleteButton) {

        new DeleteStudentGUI();
    }

    if (e.getSource() == logoutButton) {

        new LoginGUI();

        dispose();
    }
    if (e.getSource() == exportButton) {

    new ExportPDFGUI();
}
}
public void loadStudentCount() {

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "SELECT COUNT(*) FROM students";

        PreparedStatement ps =
                con.prepareStatement(query);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            int count =
                    rs.getInt(1);

            countLabel.setText(
                    "Total Students: " + count
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}
}