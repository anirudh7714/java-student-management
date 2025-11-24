package main;

import model.Student;
import services.*;
import utils.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        GradeCalculator calculator = new CalculatorImpl();
        ReportGenerator generator = new ReportGenerator();

        while (true) {
            System.out.println("\n----- Student Result System -----");
            System.out.println("1. Add Student");
            System.out.println("2. Generate Report");
            System.out.println("3. List Students");
            System.out.println("4. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1" -> {
                    try {
                        Student s = addStudent(sc);
                        students.add(s);
                        System.out.println("Student Added Successfully!");
                    } catch (InvalidMarksException e) {
                        System.err.println("ERROR: " + e.getMessage());
                    }
                }

                case "2" -> {
                    System.out.print("Enter Roll: ");
                    String roll = sc.nextLine();

                    Student found = null;

                    for (Student s : students) {
                        if (s.getRoll().equals(roll)) {
                            found = s;
                            break;
                        }
                    }

                    if (found == null) {
                        System.out.println("No student found!");
                    } else {
                        String grade = calculator.calculateGrade(found);
                        String report = generator.generateReport(found, grade);
                        System.out.println(report);
                    }
                }

                case "3" -> {
                    if (students.isEmpty()) {
                        System.out.println("No students.");
                    } else {
                        for (Student s : students) {
                            System.out.println(s.getRoll() + " - " + s.getName());
                        }
                    }
                }

                case "4" -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static Student addStudent(Scanner sc) throws InvalidMarksException {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (!InputValidator.isValidName(name)) throw new InvalidMarksException("Invalid Name!");

        System.out.print("Enter Roll: ");
        String roll = sc.nextLine();
        if (!InputValidator.isValidRoll(roll)) throw new InvalidMarksException("Invalid Roll!");

        List<Integer> marks = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            System.out.print("Enter marks for Subject " + i + ": ");

            String input = sc.nextLine();
            int m;

            try { m = Integer.parseInt(input); }
            catch (NumberFormatException e) { throw new InvalidMarksException("Marks must be integers!"); }

            if (!InputValidator.isValidMark(m)) throw new InvalidMarksException("Marks must be 0–100!");
            marks.add(m);
        }

        // anonymous class example
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("[INFO] Student Input Completed.");
            }
        };
        r.run();

        return new Student(name, roll, marks);
    }
}
