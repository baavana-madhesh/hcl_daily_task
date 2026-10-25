import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentService {

    private final Map<Integer, Student> students = new LinkedHashMap<>();

    public void addStudent(Student student) {
    Objects.requireNonNull(student, "student must not be null");
    validateStudentId(student);

    if (students.containsKey(student.getId())) {
        throw new IllegalArgumentException(
            "A student with ID " + student.getId() + " already exists"
        );
    }

    students.put(student.getId(), student);
}

    public Student findStudentById(int id) {
        return students.get(id);
    }

    public boolean updateStudent(Student student) {
        validateStudentId(student);
        Objects.requireNonNull(student, "student must not be null");
        if (!students.containsKey(student.getId())) {
            return false;
        }
        students.put(student.getId(), student);
        return true;
    }

    public boolean deleteStudent(int id) {
        return students.remove(id) != null;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students.values());
    }
    private void validateStudentId(Student student) {
    if (student.getId() <= 0) {
        throw new IllegalArgumentException(
            "Student ID must be positive"
        );
    }
}
}
