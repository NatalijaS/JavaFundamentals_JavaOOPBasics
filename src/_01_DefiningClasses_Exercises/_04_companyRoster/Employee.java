package _01_DefiningClasses_Exercises._04_companyRoster;

public class Employee implements Comparable<Employee> {
    private static final String DEFAULT_EMAIL = "n/a";
    private static final int DEFAULT_AGE = -1;

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;


    Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = DEFAULT_EMAIL;
        this.age = DEFAULT_AGE;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    double getSalary() {
        return salary;
    }

    private String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee o) {
        return Double.compare(o.getSalary(), this.getSalary());
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.getName(), this.getSalary(), this.getEmail(), this.getAge());
    }
}
