package _01_DefiningClasses_Exercises._04_companyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department implements Comparable<Department> {
    private String name;
    private List<Employee> employees;

    Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    private Double getAverageSalary() {
        Double sum = 0.0d;
        for (Employee employee : this.employees) {
            sum += employee.getSalary();
        }
        return sum / this.employees.size();
    }

    @Override
    public int compareTo(Department o) {
        return Double.compare(o.getAverageSalary(), this.getAverageSalary());
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        this.employees
                .stream()
                .sorted()
                .forEach(employee -> output.append(employee).append(System.lineSeparator()));
        return output.toString();
    }
}
