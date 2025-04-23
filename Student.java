package StudentManagementSystem;

import java.sql.*;
import java.util.Scanner;

public class Student {
    private Connection con;
    private Scanner scanner;

    public Student() {
        try {
            con = DBConnection.getConnection();
            scanner = new Scanner(System.in);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addStudent() {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Grade: ");
        String grade = scanner.nextLine();

        try {
            String sql = "INSERT INTO students (name, age, grade) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void viewStudents() {
        try {
            String sql = "SELECT * FROM students";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("ID\tName\t\tAge\tGrade");
            System.out.println("--------------------------------");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t\t" + rs.getInt("age") + "\t" + rs.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Grade: ");
        String grade = scanner.nextLine();

        try {
            String sql = "UPDATE students SET name=?, age=?, grade=? WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, grade);
            pstmt.setInt(4, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        try {
            String sql = "DELETE FROM students WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            con.close();
            scanner.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
