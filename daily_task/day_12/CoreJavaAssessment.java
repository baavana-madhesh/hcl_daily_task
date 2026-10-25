
import java.util.ArrayList;
import java.util.List;

class Student {
    private final int id;
    private final String name;
    private final int marks;

    public Student(int id, String name, int marks) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid student ID");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be 0-100");
        }

        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + marks;
    }
}

public class CoreJavaAssessment {
    private static final List<Student> students = new ArrayList<>();

    private static void addStudent(Student student) {
        for (Student existing : students) {
            if (existing.getId() == student.getId()) {
                throw new IllegalArgumentException("Duplicate student ID");
            }
        }
        students.add(student);
    }

    private static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        try {
            addStudent(new Student(101, "Arun", 85));
            addStudent(new Student(102, "Priya", 92));

            System.out.println("=== Student Management ===");
            displayStudents();

            System.out.println("\n=== Search Student ===");
            int searchId = 102;

            Student found = null;
            for (Student student : students) {
                if (student.getId() == searchId) {
                    found = student;
                    break;
                }
            }

            if (found != null) {
                System.out.println("Found: " + found);
            } else {
                System.out.println("Student not found.");
            }

            System.out.println("\n=== Exception Handling ===");
            try {
                addStudent(new Student(101, "Duplicate", 70));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Assessment error: " + e.getMessage());
        }
    }
}
