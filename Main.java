import java.io.*;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Part I: Dynamic Binding Demonstration ===");
        Course courseRef = new OnlineCourse("Comp - 305", "Object Oriented Programming 2 (Java)", "Zoom");
        courseRef.showDetails(); 
        // Explanation: The overridden showDetails() in OnlineCourse is called due to dynamic (runtime) binding/polymorphism.

        System.out.println("\n=== Part III: HashMap and Iteration ===");
        HashMap<String, Integer> studentGrades = new HashMap<>();
        studentGrades.put("Alice", 85);
        studentGrades.put("Bob", 92);
        studentGrades.put("Charlie", 78);

        // Iteration using enhanced for loop over entrySet
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Grade: " + entry.getValue() + "%");
        }

        System.out.println("\n=== Part III: Custom Exception Handling ===");
        try {
            String missingStudent = "Leevayle Kinanga";
            Integer grade = studentGrades.get(missingStudent);
            if (grade == null) {
                throw new GradeNotFoundException("Grade not found for student: " + missingStudent);
            }
            System.out.println("Grade: " + grade);
        } catch (GradeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Part IV: File Processing ===");
        processFile();
        System.out.println("File processing complete! Check output.txt (uppercase version of input.txt)");
    }

    // File processing method using Character Streams (try-with-resources for auto-close)
    public static void processFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    // Other code i'll write in future for Part II: JDBC Login Validation



    // JDBC login validation method (as event handler)
    public static void loginButton_Click(String regNoInput, String passwordInput) {
        String url = "jdbc:mysql://localhost:3306/university?useSSL=false";
        String user = "root";        
        String pass = ""; 

        try (Connection conn = DriverManager.getConnection(url, user, pass);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM students WHERE regNo = ? AND password = ?")) {
            
            pstmt.setString(1, regNoInput);
            pstmt.setString(2, passwordInput);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Login successful for " + regNoInput);
            } else {
                System.out.println("Invalid credentials");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}