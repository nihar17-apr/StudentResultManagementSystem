import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class SearchStudentGUI extends JFrame
        implements ActionListener {

    JLabel rollLabel;

    JTextField rollField;

    JButton searchButton;

    JTextArea resultArea;

    SearchStudentGUI() {

        setTitle("Search Student");

        setSize(500, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        rollLabel =
                new JLabel("Enter Roll No:");

        rollLabel.setBounds(50, 40, 120, 30);

        add(rollLabel);

        rollField =
                new JTextField();

        rollField.setBounds(180, 40, 180, 30);

        add(rollField);

        searchButton =
                new JButton("Search");

        searchButton.setBounds(180, 90, 120, 35);

        searchButton.addActionListener(this);

        add(searchButton);

        resultArea =
                new JTextArea();

        resultArea.setBounds(50, 150, 380, 150);

        add(resultArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            String rollNo =
                    rollField.getText();

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM students WHERE roll_no = ?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, rollNo);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                resultArea.setText(

                        "ID: " +
                        rs.getInt("id") +

                        "\nName: " +
                        rs.getString("name") +

                        "\nRoll No: " +
                        rs.getString("roll_no") +

                        "\nDepartment: " +
                        rs.getString("department") +

                        "\nMarks: " +
                        rs.getInt("marks") +

                        "\nGrade: " +
                        rs.getString("grade")
                );

            } else {

                resultArea.setText(
                        "Student Not Found"
                );
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}