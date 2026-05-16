import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO dao = new StudentDAO();
    
System.out.println("===== ADMIN LOGIN =====");

System.out.print("Enter Username: ");
String username = sc.next();

System.out.print("Enter Password: ");
String password = sc.next();

boolean login =
        dao.adminLogin(
                username,
                password
        );

if (!login) {

    System.out.println(
            "Invalid Username or Password"
    );

    System.exit(0);
}

System.out.println(
        "\nLogin Successful\n"
);
        while (true) {

            System.out.println("\n===== STUDENT RESULT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Exit");

            System.out.print("\nEnter Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    sc.nextLine();
                    if (name.isEmpty()) 
                        {
                            System.out.println("Name cannot be empty");
                            continue;
                        }
                    System.out.print("Enter Roll No: ");
                    String roll = sc.nextLine();
                    if (roll.isEmpty()) 
                        {
                            System.out.println("Roll Number cannot be empty");
                            continue;
                        }
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                   if (marks < 0 || marks > 100) 
                    {
                        System.out.println( "Invalid Marks! Marks should be between 0 and 100.");
                        continue;
                    }

                  Student s =new Student( name,roll,dept,marks);
                    dao.addStudent(s);
                    break;
                case 2:
                    dao.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter New Marks: ");
                    int newMarks = sc.nextInt();
                    dao.updateStudent(
                            updateId,
                            newMarks
                    );
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    int deleteId = sc.nextInt();
                    dao.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.print("Enter Roll Number: ");
                    String rollNo = sc.next();
                    dao.searchStudent(rollNo);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}