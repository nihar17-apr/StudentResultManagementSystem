import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ViewStudentsGUI extends JFrame {

    JTable table;

    DefaultTableModel model;

    ViewStudentsGUI() {

        setTitle("View Students");

        setSize(800, 400);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {
                "ID",
                "Name",
                "Roll No",
                "Department",
                "Marks",
                "Grade"
        };

        model = new DefaultTableModel(columns, 0);

        table = new JTable(model);

        JScrollPane pane =
                new JScrollPane(table);

        add(pane);

        loadStudents();

        setVisible(true);
    }

    public void loadStudents() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM students";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Object[] row = {

                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("roll_no"),
                        rs.getString("department"),
                        rs.getInt("marks"),
                        rs.getString("grade")
                };

                model.addRow(row);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}