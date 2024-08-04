public class CourseEnrollment {
    public static void main(String[] args) {
        // course catalog
        Course[] courseCatalog = {
                new Course(1, "Mathematics", 3),
                new Course(2, "Physics", 4),
                new Course(3, "Chemistry", 4)
        };

        // make Enrollment object
        Enrollment enrollment = new Enrollment(5, 10); // 5 students, max 10 courses each

        // Enroll students in courses
        enrollment.enroll(0, 1); // Student 0 enrolls in Mathematics
        enrollment.enroll(0, 2); // Student 0 enrolls in Physics
        enrollment.enroll(1, 3); // Student 1 enrolls in Chemistry

        // Print enrolled courses for a student
        enrollment.getEnrolledCourses(0, courseCatalog);

        // Drop a course for a student
        enrollment.drop(0, 1); // Student 0 drops Mathematics

        // Print enrolled courses again
        enrollment.getEnrolledCourses(0, courseCatalog);
    }
}
