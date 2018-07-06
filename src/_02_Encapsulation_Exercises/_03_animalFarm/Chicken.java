package _02_Encapsulation_Exercises._03_animalFarm;

public class Chicken {
    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.name = this.setName(name);
        this.age = this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private String setName(String name) {
        if (name.length() < 1 || name.charAt(0) == ' ') {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        return this.name = name;
    }

    private int setAge(int age) {
        if (age > 15 || age < 0) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        return this.age = age;
    }

    public double getProductPerDay() {
        return calculateProductPerDay(this.getAge());
    }

    private double calculateProductPerDay(int age) {
        if (age < 6) {
            return 2;
        } else if (age < 12) {
            return 1;
        } else {
            return 0.75;
        }
    }

    @Override
    public String toString() {
        if(this.age <= 12){
            return "Chicken " + this.name + " (age " + this.age + ") can produce " + (int)this.calculateProductPerDay(this.getAge())+ " eggs per day.";
        }else{
        return "Chicken " + this.name + " (age " + this.age + ") can produce " + this.calculateProductPerDay(this.getAge())+ " eggs per day.";
        }
    }
}
