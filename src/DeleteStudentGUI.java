import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.*;

public class DeleteStudentGUI extends JFrame
        implements ActionListener {

    JLabel idLabel;

    JTextField idField;

    JButton deleteButton;

    DeleteStudentGUI() {

        setTitle("Delete Student");

        setSize(400, 250);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        idLabel =
                new JLabel("Student ID:");

        idLabel.setBounds(50, 50, 120, 30);

        add(idLabel);

        idField =
                new JTextField();

        idField.setBounds(170, 50, 150, 30);

        add(idField);

        deleteButton =
                new JButton("Delete");

        deleteButton.setBounds(130, 120, 120, 40);

        deleteButton.addActionListener(this);

        add(deleteButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            int id =
                    Integer.parseInt(
                            idField.getText()
                    );

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "DELETE FROM students WHERE id = ?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1, id);

            int rows =
                    ps.executeUpdate();

            if (rows > 0) {

                JOptionPane.showMessageDialog(
                        this,
                        "Student Deleted Successfully"
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