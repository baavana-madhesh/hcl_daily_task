import java.util.Objects;

public class Student {

    private int id;
    private String name;
    private String email;

    public Student(int id, String name, String email) {
        this.id = id;
        setName(name);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateRequiredText(name, "name");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateRequiredText(email, "email");
        this.email = email;
    }

    private static void validateRequiredText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be null or blank");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Student)) {
            return false;
        }
        Student student = (Student) object;
        return id == student.id
                && name.equals(student.name)
                && email.equals(student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "Student{id=" + id
                + ", name='" + name + '\''
                + ", email='" + email + '\''
                + '}';
    }
}