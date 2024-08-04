public class Enrollment {
    private int[][] studentCourses; // 2D array to store student-course enrollments
    private int[] count; // Array to track number of courses each student is enrolled in

    public Enrollment(int numStudents, int maxCourses) {
        studentCourses = new int[numStudents][maxCourses];
        count = new int[numStudents];
    }

    public void enroll(int studentID, int courseID) {
        studentCourses[studentID][count[studentID]++] = courseID;
        System.out.println("Student " + studentID + " enrolled in course " + courseID);
    }

    public void drop(int studentID, int courseID) {
        boolean found = false;
        for (int i = 0; i < count[studentID]; i++) {
            if (studentCourses[studentID][i] == courseID) {
                found = true;
                for (int j = i; j < count[studentID] - 1; j++) {
                    studentCourses[studentID][j] = studentCourses[studentID][j + 1];
                }
                count[studentID]--;
                System.out.println("Student " + studentID + " dropped course " + courseID);
                break;
            }
        }
        if (!found) {
            System.out.println("Course " + courseID + " not found for student " + studentID);
        }
    }

    public void getEnrolledCourses(int studentID, Course[] courseCatalog) {
        System.out.println("Courses enrolled by student " + studentID + ":");
        for (int i = 0; i < count[studentID]; i++) {
            int courseID = studentCourses[studentID][i];
            for (Course course : courseCatalog) {
                if (course.getCourseID() == courseID) {
                    System.out.println(course);
                }
            }
        }
    }
}
