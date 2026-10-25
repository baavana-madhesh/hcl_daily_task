public class StudentServiceTest {

    public static void main(String[] args) {
        StudentService service = new StudentService();

        try {
            service.addStudent(
                new Student(0, "Arun", "arun@gmail.com")
            );

            throw new AssertionError(
                "Expected invalid student ID to be rejected"
            );
        } catch (IllegalArgumentException e) {
            if (!"Student ID must be positive".equals(e.getMessage())) {
                throw e;
            }
            System.out.println("PASS: Invalid student ID rejected");
        }
    }
}