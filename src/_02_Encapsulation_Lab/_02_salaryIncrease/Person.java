package _02_Encapsulation_Lab._02_salaryIncrease;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    void increaseSalary(int bonus) {
        if (this.age < 30) {
            this.salary += this.salary * bonus / 200;
        } else {
            this.salary += this.salary * bonus / 100;
        }
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " gets " + this.salary + " leva";
    }

}
