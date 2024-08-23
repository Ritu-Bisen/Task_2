import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManager {

    private static final Scanner scanner = new Scanner(System.in);
    private ArrayList<Double> grades = new ArrayList<>();

    public static void main(String[] args) {
        StudentGradeManager manager = new StudentGradeManager();
        manager.run();
    }

    public void run() {
        System.out.println("Welcome to the Student Grade Manager");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Input grade");
            System.out.println("2. Calculate average grade");
            System.out.println("3. Display overall grade");
            System.out.println("4. Exit");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    inputGrade();
                    break;
                case 2:
                    calculateAverageGrade();
                    break;
                case 3:
                    displayOverallGrade();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private int getUserChoice() {
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    System.out.println("Choice out of range. Please enter a number between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private void inputGrade() {
        while (true) {
            try {
                System.out.print("Enter the grade (0-100): ");
                double grade = Double.parseDouble(scanner.nextLine());
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                    System.out.println("Grade added successfully.");
                    break;
                } else {
                    System.out.println("Grade must be between 0 and 100. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    private void calculateAverageGrade() {
        if (grades.isEmpty()) {
            System.out.println("No grades available to calculate the average.");
            return;
        }

        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        System.out.printf("Average Grade: %.2f%n", average);
    }

    private void displayOverallGrade() {
        if (grades.isEmpty()) {
            System.out.println("No grades available to display.");
            return;
        }

        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        String letterGrade = getLetterGrade(average);
        double gpa = calculateGPA(average);

        System.out.printf("Average Grade: %.2f%n", average);
        System.out.printf("Letter Grade: %s%n", letterGrade);
        System.out.printf("GPA: %.2f%n", gpa);
    }

    private String getLetterGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    private double calculateGPA(double average) {
        return average / 20; // Assuming GPA is on a 0-5 scale
    }
}
