package exams._2017_08_03_PawInc.models.animals;

public class Dog extends Animal {

    private int commands;

    public Dog(String name, int age, String adoptionCenter, int commands) {
        super(name, age, adoptionCenter);
        this.commands = commands;
    }

    public Dog(String name, int age) {
        super(name, age);
    }
}
