class GradingSystem {
    private Student[] students;
    private Grade[] grades;
    private int[] courseCredits;
    private int studentCount;
    private int gradeCount;
    private int courseCount;

    public GradingSystem(int maxStudents, int maxGrades, int maxCourses) {
        students = new Student[maxStudents];
        grades = new Grade[maxGrades];
        courseCredits = new int[maxCourses];
        studentCount = 0;
        gradeCount = 0;
        courseCount = 0;
    }

    public void addStudent(Student student) {
        if (studentCount < students.length) {
            students[studentCount++] = student;
        } else {
            System.out.println("Maximum number of students reached.");
        }
    }

    public void addGrade(Grade grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount++] = grade;
        } else {
            System.out.println("Maximum number of grades reached.");
        }
    }

    public void addCourseCredits(int courseID, int credits) {
        if (courseID < courseCredits.length) {
            courseCredits[courseID] = credits;
            courseCount++;
        } else {
            System.out.println("Course ID exceeds the limit.");
        }
    }

    public double calculateGPA(int studentID) {
        int totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentID() == studentID) {
                int credits = courseCredits[grades[i].getCourseID()];
                totalPoints += gradeToPoints(grades[i].getGrade()) * credits;
                totalCredits += credits;
            }
        }

        if (totalCredits == 0) {
            return 0.0;
        }
        return (double) totalPoints / totalCredits;
    }

    private int gradeToPoints(char grade) {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }

    public void printGradeReport(int studentID) {
        Student student = null;
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentID() == studentID) {
                student = students[i];
                break;
            }
        }

        if (student == null) {
            System.out.println("Student ID not found!");
            return;
        }

        System.out.println(student);
        System.out.println("Grades:");

        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentID() == studentID) {
                System.out.println("Course ID: " + grades[i].getCourseID() + ", Grade: " + grades[i].getGrade());
            }
        }

        System.out.println("GPA: " + calculateGPA(studentID));
    }
}
