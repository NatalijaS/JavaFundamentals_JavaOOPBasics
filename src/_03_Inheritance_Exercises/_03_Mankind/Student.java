package _03_Inheritance_Exercises._03_Mankind;

public class Student extends Human {
    private String facultyNumber;

    public Student(String firstName, String lastName, String facultyNumber) {
        super(firstName, lastName);
        this.setFacultyNumber(facultyNumber);
    }

    private void setFacultyNumber(String facultyNumber) {
        if (facultyNumber.length() > 10 || facultyNumber.length() < 5) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }
        this.facultyNumber = facultyNumber;
    }

    private String getFacultyNumber() {
        return facultyNumber;
    }

    @Override
    public String toString() {
        return String.format("First Name: %s", super.getFirstName()) +
                System.lineSeparator() +
                String.format("Last Name: %s", super.getLastName()) +
                System.lineSeparator() +
                String.format("Faculty number: %s", this.getFacultyNumber());
    }
}
