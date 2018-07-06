package _03_Inheritance_Exercises._03_Mankind;

public class Worker extends Human {
    private double weekSalary;
    private double workingHours;

    public Worker(String firstName, String lastName, double weekSalary, double workingHours) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkingHours(workingHours);
    }

    private void setWeekSalary(double weekSalary) {
        if (weekSalary <= 10) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkingHours(double workingHours) {
        if (workingHours < 1 || workingHours > 12) {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = workingHours;
    }

    private double getWeekSalary() {
        return weekSalary;
    }

    private double getWorkingHours() {
        return workingHours;
    }

    private double calculateSalaryPerHour() {
        return this.getWeekSalary() / this.getWorkingHours();
    }

    @Override
    public String toString() {
        return String.format("First Name: %s", super.getFirstName()) +
                System.lineSeparator() +
                String.format("Last Name: %s", super.getLastName()) +
                System.lineSeparator() +
                String.format("Week Salary: %.2f", this.getWeekSalary()) +
                System.lineSeparator() +
                String.format("Hours per day: %.2f", this.getWorkingHours()) +
                System.lineSeparator() +
                String.format("Salary per hour: %.2f", this.calculateSalaryPerHour());
    }
}
