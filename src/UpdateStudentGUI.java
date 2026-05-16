import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class UpdateStudentGUI extends JFrame
        implements ActionListener {

    JLabel idLabel, marksLabel;

    JTextField idField, marksField;

    JButton updateButton;

    UpdateStudentGUI() {

        setTitle("Update Student Marks");

        setSize(400, 300);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        idLabel =
                new JLabel("Student ID:");

        idLabel.setBounds(50, 50, 120, 30);

        add(idLabel);

        idField =
                new JTextField();

        idField.setBounds(180, 50, 150, 30);

        add(idField);

        marksLabel =
                new JLabel("New Marks:");

        marksLabel.setBounds(50, 110, 120, 30);

        add(marksLabel);

        marksField =
                new JTextField();

        marksField.setBounds(180, 110, 150, 30);

        add(marksField);

        updateButton =
                new JButton("Update");

        updateButton.setBounds(130, 180, 120, 40);

        updateButton.addActionListener(this);

        add(updateButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText()
                    );

            int marks =
                    Integer.parseInt(
                            marksField.getText()
                    );

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "UPDATE students SET marks = ?, grade = ? WHERE id = ?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            String grade;

            if (marks >= 90) {

                grade = "A+";

            } else if (marks >= 75) {

                grade = "A";

            } else if (marks >= 60) {

                grade = "B";

            } else if (marks >= 50) {

                grade = "C";

            } else {

                grade = "F";
            }

            ps.setInt(1, marks);

            ps.setString(2, grade);

            ps.setInt(3, id);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student Updated Successfully"
                );

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "Student Not Found"
                );
            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input"
            );
        }
    }
}