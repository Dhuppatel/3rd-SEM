class StudentRecordSystem {
    private Student[] students;
    private int count;

    public StudentRecordSystem(int capacity) {
        students = new Student[capacity];
        count = 0;
    }

    public void addStudent(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
            System.out.println("Student added successfully.");
        } else {
            System.out.println("No more students can be added. Capacity reached.");
        }
    }

    public Student getStudent(int studentID) {
        for (int i = 0; i < count; i++) {
            if (students[i].getStudentID() == studentID) {
                return students[i];
            }
        }
        return null; //  not found
    }

    public void displayAllStudents() {
        if (count == 0) {
            System.out.println("No student found.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(students[i]);
                System.out.println("-------------------------");
            }
        }
    }
}
