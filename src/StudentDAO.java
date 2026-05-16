import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    public void addStudent(Student s) {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "INSERT INTO students(name, roll_no, department, marks, grade) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, s.name);
            ps.setString(2, s.rollNo);
            ps.setString(3, s.department);
            ps.setInt(4, s.marks);
            ps.setString(5, s.grade);

            ps.executeUpdate();

            System.out.println(
                    "Student Added Successfully"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
   public void viewStudents() {

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "SELECT * FROM students";

        PreparedStatement ps =
                con.prepareStatement(query);

        ResultSet rs =
                ps.executeQuery();

        System.out.println("\n===== STUDENT RECORDS =====\n");

        while (rs.next()) {

            System.out.println(
                    "ID: " + rs.getInt("id") +
                    " | Name: " + rs.getString("name") +
                    " | Roll No: " + rs.getString("roll_no") +
                    " | Department: " + rs.getString("department") +
                    " | Marks: " + rs.getInt("marks") +
                    " | Grade: " + rs.getString("grade")
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}
public void updateStudent(int id, int marks) {

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "UPDATE students SET marks = ? WHERE id = ?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, marks);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {

            System.out.println(
                    "Student Updated Successfully"
            );

        } else {

            System.out.println(
                    "Student Not Found"
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}
public void deleteStudent(int id) {

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "DELETE FROM students WHERE id = ?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {

            System.out.println(
                    "Student Deleted Successfully"
            );

        } else {

            System.out.println(
                    "Student Not Found"
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}
public void searchStudent(String rollNo) {

    try {

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

            System.out.println("\n===== STUDENT FOUND =====\n");

            System.out.println(
                    "ID: " + rs.getInt("id") +
                    " | Name: " + rs.getString("name") +
                    " | Roll No: " + rs.getString("roll_no") +
                    " | Department: " + rs.getString("department") +
                    " | Marks: " + rs.getInt("marks") +
                    " | Grade: " + rs.getString("grade")
            );

        } else {

            System.out.println(
                    "Student Not Found"
            );
        }

    } catch (Exception e) {

        e.printStackTrace();
    }
}
public boolean adminLogin(
        String username,
        String password
) {

    try {

        Connection con =
                DBConnection.getConnection();

        String query =
                "SELECT * FROM admin WHERE username = ? AND password = ?";

        PreparedStatement ps =
                con.prepareStatement(query);

        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs =
                ps.executeQuery();

        return rs.next();

    } catch (Exception e) {

        e.printStackTrace();
    }

    return false;
}
}