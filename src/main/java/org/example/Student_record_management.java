package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}


 public class Student_record_management{
        static ArrayList<Student> studentList = new ArrayList<>();
        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int choice;
            do {
                System.out.println("\n=== Student Record Management System ===");
                System.out.println("1. Add Student");
                System.out.println("2. View Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice (1-5): ");
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudents();
                        break;
                    case 3:
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        System.out.println("Exiting system...");
                        break;
                    default:
                        System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 5);
        }

        // Add a new student
        public static void addStudent() {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // consume newline

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Marks: ");
            int marks = scanner.nextInt();

            Student s = new Student(id, name, marks);
            studentList.add(s);
            System.out.println("Student added successfully.");
        }

        // View all students
        public static void viewStudents() {
            if (studentList.isEmpty()) {
                System.out.println("No student records found.");
            } else {
                System.out.println("\n-- Student Records --");
                for (Student s : studentList) {
                    System.out.println(s);
                }
            }
        }

        // Update existing student
        public static void updateStudent() {
            System.out.print("Enter ID of student to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            boolean found = false;
            for (Student s : studentList) {
                if (s.getId() == id) {
                    System.out.print("Enter new Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new Marks: ");
                    int marks = scanner.nextInt();
                    s.setName(name);
                    s.setMarks(marks);
                    System.out.println("Student updated successfully.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student with ID " + id + " not found.");
            }
        }

        // Delete student by ID
        public static void deleteStudent() {
            System.out.print("Enter ID of student to delete: ");
            int id = scanner.nextInt();

            boolean removed = studentList.removeIf(s -> s.getId() == id);

            if (removed) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        }
    }
