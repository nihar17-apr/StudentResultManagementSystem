public class Student {

    int id;
    String name;
    String rollNo;
    String department;
    int marks;
    String grade;

    public Student(
        String name,
        String rollNo,
        String department,
        int marks
) {

    this.name = name;
    this.rollNo = rollNo;
    this.department = department;
    this.marks = marks;

    if (marks >= 90) {

        this.grade = "A+";

    } else if (marks >= 75) {

        this.grade = "A";

    } else if (marks >= 60) {

        this.grade = "B";

    } else if (marks >= 50) {

        this.grade = "C";

    } else {

        this.grade = "F";
    }
}
}