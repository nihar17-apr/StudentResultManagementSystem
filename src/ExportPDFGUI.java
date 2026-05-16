import javax.swing.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

public class ExportPDFGUI extends JFrame
        implements ActionListener {

    JButton exportButton;

    ExportPDFGUI() {

        setTitle("Export PDF");

        setSize(400, 250);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        exportButton =
                new JButton("Export Student Report");

        exportButton.setBounds(80, 80, 220, 50);

        exportButton.addActionListener(this);

        add(exportButton);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            Document document =
                    new Document();

            PdfWriter.getInstance(
                    document,
                    new FileOutputStream(
                            "Student_Report.pdf"
                    )
            );

            document.open();

            Paragraph title =
                    new Paragraph(
                            "Student Report\n\n"
                    );

            document.add(title);

            PdfPTable table =
                    new PdfPTable(6);

            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Roll No");
            table.addCell("Department");
            table.addCell("Marks");
            table.addCell("Grade");

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "SELECT * FROM students";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                table.addCell(
                        String.valueOf(
                                rs.getInt("id")
                        )
                );

                table.addCell(
                        rs.getString("name")
                );

                table.addCell(
                        rs.getString("roll_no")
                );

                table.addCell(
                        rs.getString("department")
                );

                table.addCell(
                        String.valueOf(
                                rs.getInt("marks")
                        )
                );

                table.addCell(
                        rs.getString("grade")
                );
            }

            document.add(table);

            document.close();

            JOptionPane.showMessageDialog(
                    this,
                    "PDF Exported Successfully"
            );

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }
}