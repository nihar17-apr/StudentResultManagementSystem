// AddStudentGUI.java

import java.awt.event.*;
import javax.swing.*;

public class AddStudentGUI extends JFrame
        implements ActionListener {

    JLabel nameLabel, rollLabel,
            deptLabel, marksLabel;

    JTextField nameField,
            rollField,
            deptField,
            marksField;

    JButton addButton;

    StudentDAO dao = new StudentDAO();

    AddStudentGUI() {

        setTitle("Add Student");

        setSize(400, 400);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nameLabel = new JLabel("Name:");

        nameLabel.setBounds(50, 50, 100, 30);

        add(nameLabel);

        nameField = new JTextField();

        nameField.setBounds(150, 50, 150, 30);

        add(nameField);

        rollLabel = new JLabel("Roll No:");

        rollLabel.setBounds(50, 100, 100, 30);

        add(rollLabel);

        rollField = new JTextField();

        rollField.setBounds(150, 100, 150, 30);

        add(rollField);

        deptLabel = new JLabel("Department:");

        deptLabel.setBounds(50, 150, 100, 30);

        add(deptLabel);

        deptField = new JTextField();

        deptField.setBounds(150, 150, 150, 30);

        add(deptField);

        marksLabel = new JLabel("Marks:");

        marksLabel.setBounds(50, 200, 100, 30);

        add(marksLabel);

        marksField = new JTextField();

        marksField.setBounds(150, 200, 150, 30);

        add(marksField);

        addButton = new JButton("Add Student");

        addButton.setBounds(120, 280, 150, 40);

        addButton.addActionListener(this);

        add(addButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            String name =
                    nameField.getText();

            String roll =
                    rollField.getText();

            String dept =
                    deptField.getText();

            int marks =
                    Integer.parseInt(
                            marksField.getText()
                    );

            Student s =
                    new Student(
                            name,
                            roll,
                            dept,
                            marks
                    );

            dao.addStudent(s);

            JOptionPane.showMessageDialog(
                    this,
                    "Student Added Successfully"
            );

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "Invalid Input"
            );
        }
    }
}