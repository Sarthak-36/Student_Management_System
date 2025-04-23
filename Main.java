package StudentManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student stu = new Student();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    stu.addStudent();
                    break;
                case 2:
                    stu.viewStudents();
                    break;
                case 3:
                    stu.updateStudent();
                    break;
                case 4:
                    stu.deleteStudent();
                    break;
                case 5:
                    stu.close();
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
