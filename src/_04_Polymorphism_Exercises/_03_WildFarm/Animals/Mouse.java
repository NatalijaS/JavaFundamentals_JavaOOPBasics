package _04_Polymorphism_Exercises._03_WildFarm.Animals;

import _04_Polymorphism_Exercises._03_WildFarm.Foods.Food;

public class Mouse extends Mammal{
    public Mouse(String name, Double weight, String livingRegion) {
        super(name, weight, livingRegion);
    }

    public void makeSound () {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat (Food f) {
        if (f.getClass().getSimpleName().equals("Meat")) {
            System.out.println(this.getClass().getSimpleName() + "s are not eating that type of food!");
            f.setQuantity(0);
        } else {
            System.out.println("A cheese was just eaten!");
        }
        this.setFoodEaten(f.getQuantity());
    }
}
