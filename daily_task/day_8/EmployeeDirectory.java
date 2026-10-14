import java.util.*;

class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    // Natural ordering: employee ID in ascending order
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    // Logical equality is based on employee ID
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Employee)) {
            return false;
        }

        Employee other = (Employee) obj;
        return this.id == other.id;
    }

    // Must be consistent with equals()
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "ID: " + id
                + ", Name: " + name
                + ", Department: " + department
                + ", Salary: " + salary;
    }
}

public class EmployeeDirectory {

    public static void main(String[] args) {

        // Sample employee records
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(104, "Priya", "Java", 65000));
        employees.add(new Employee(101, "Arun", "Java", 85000));
        employees.add(new Employee(103, "Kumar", "SQL", 55000));
        employees.add(new Employee(102, "Divya", "SQL", 75000));
        employees.add(new Employee(105, "Ravi", "Java", 85000));
        employees.add(new Employee(106, "Meena", "Testing", 50000));
        employees.add(new Employee(107, "Kavin", "Testing", 60000));

        // FR4: Employee lookup using HashMap
        Map<Integer, Employee> employeeMap = new HashMap<>();

        for (Employee employee : employees) {
            employeeMap.put(employee.getId(), employee);
        }

        System.out.println("=== EMPLOYEE LOOKUP ===");

        int searchId = 103;
        Employee found = employeeMap.get(searchId);

        if (found != null) {
            System.out.println(found);
        } else {
            System.out.println("Employee not found: " + searchId);
        }

        // FR5: Count employees in each department using merge()
        Map<String, Integer> departmentCounts = new HashMap<>();

        for (Employee employee : employees) {
            departmentCounts.merge(
                    employee.getDepartment(),
                    1,
                    Integer::sum
            );
        }

        // TreeMap sorts department names by key
        Map<String, Integer> sortedReport =
                new TreeMap<>(departmentCounts);

        System.out.println("\n=== DEPARTMENT REPORT ===");

        for (Map.Entry<String, Integer> entry : sortedReport.entrySet()) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue() + " employees"
            );
        }

        // FR6: Comparable sorts by employee ID
        Collections.sort(employees);

        System.out.println("\n=== EMPLOYEES SORTED BY ID ===");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Comparator 1: Salary descending, then ID ascending
        Comparator<Employee> salaryComparator =
                Comparator.comparingDouble(Employee::getSalary)
                        .reversed()
                        .thenComparingInt(Employee::getId);

        employees.sort(salaryComparator);

        System.out.println("\n=== TOP 5 HIGHEST-PAID EMPLOYEES ===");

        for (int i = 0; i < Math.min(5, employees.size()); i++) {
            System.out.println(employees.get(i));
        }

        // Comparator 2: Department ascending, then name ascending
        Comparator<Employee> departmentComparator =
                Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getName);

        employees.sort(departmentComparator);

        System.out.println("\n=== SORTED BY DEPARTMENT AND NAME ===");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Demonstrate equals() and hashCode() contract
        Employee first = new Employee(101, "Arun", "Java", 85000);
        Employee duplicate = new Employee(101, "Arun Updated", "SQL", 90000);

        Set<Employee> employeeSet = new HashSet<>();
        employeeSet.add(first);
        employeeSet.add(duplicate);

        System.out.println("\n=== EQUALS AND HASHCODE DEMO ===");
        System.out.println("Are employees equal? " + first.equals(duplicate));
        System.out.println("Same hash code? "
                + (first.hashCode() == duplicate.hashCode()));
        System.out.println("HashSet size: " + employeeSet.size());
    }
}