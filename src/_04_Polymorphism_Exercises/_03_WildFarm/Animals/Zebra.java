package _04_Polymorphism_Exercises._03_WildFarm.Animals;

public class Zebra extends Mammal{
    public Zebra(String name, Double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    public void makeSound () {
        System.out.println("Zs");
    }
}