import java.util.Scanner;

public class GradingSystemMGTM {

    public static void main(String[] args) {
        GradingSystem gradingSystem = new GradingSystem(100, 1000, 10);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Grading System Menu ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course Credits");
            System.out.println("3. Add Grade");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addStudent(gradingSystem, scanner);
                    break;
                case 2:
                    addCourseCredits(gradingSystem, scanner);
                    break;
                case 3:
                    addGrade(gradingSystem, scanner);
                    break;
                case 4:
                    calculateGPA(gradingSystem, scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addStudent(GradingSystem gradingSystem, Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        gradingSystem.addStudent(new Student(studentID, name));
        System.out.println("Student added successfully.");
    }

    private static void addCourseCredits(GradingSystem gradingSystem, Scanner scanner) {
        System.out.print("Enter Course ID: ");
        int courseID = scanner.nextInt();
        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();
        gradingSystem.addCourseCredits(courseID, credits);
        System.out.println("Course credits added successfully.");
    }

    private static void addGrade(GradingSystem gradingSystem, Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();
        System.out.print("Enter Course ID: ");
        int courseID = scanner.nextInt();
        System.out.print("Enter Grade (A, B, C, D, F): ");
        char grade = scanner.next().charAt(0);
        gradingSystem.addGrade(new Grade(studentID, courseID, grade));
        System.out.println("Grade added successfully.");
    }

    private static void calculateGPA(GradingSystem gradingSystem, Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();
        double gpa = gradingSystem.calculateGPA(studentID);
        System.out.println("Student GPA: " + gpa);
    }
}
