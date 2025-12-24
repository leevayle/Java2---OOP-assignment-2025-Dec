import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String regNo;
    private String name;
    private String email;

    // Default constructor
    public Student() {
    }

    // Overloaded constructor
    public Student(String regNo, String name, String email) {
        this.regNo = regNo;
        this.name = name;
        this.email = email;
    }

    // Getters and setters (encapsulation)
    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Implement compareTo for Comparable interface (natural ordering by regNo)
    @Override
    public int compareTo(Student other) {
        return this.regNo.compareTo(other.regNo);
    }

    // Brief explanation: The Comparable interface allows objects to be sorted in Java Collections
    // (e.g., ArrayList.sort() or Collections.sort()) by defining a natural order via compareTo().
    // Here, students are ordered alphabetically by regNo using String comparison.
}