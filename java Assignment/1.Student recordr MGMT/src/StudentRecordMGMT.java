public class StudentRecordMGMT {
    public static void main(String[] args) {
        StudentRecordSystem recordSystem = new StudentRecordSystem(100);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add New Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    Student newStudent = new Student(id, name, age, department);
                    recordSystem.addStudent(newStudent);
                    break;

                case 2:
                    recordSystem.displayAllStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to search: ");
                    int searchID = scanner.nextInt();
                    Student student = recordSystem.getStudent(searchID);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student with ID " + searchID + " not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice! ");
            }

        } while (choice != 4);

        scanner.close();
    }
}
