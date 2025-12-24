import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String title;
    private ArrayList<Student> students = new ArrayList<>();

    // Default constructor
    public Course() {
    }

    // Overloaded constructor
    public Course(String courseCode, String title) {
        this.courseCode = courseCode;
        this.title = title;
    }

    // Enroll student method
    public void enrollStudent(Student s) {
        students.add(s);
    }

    // Show details method (to be overridden)
    public void showDetails() {
        System.out.println("Course Code: " + courseCode + ", Title: " + title);
    }
}