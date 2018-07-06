package _04_Polymorphism_Exercises._03_WildFarm;

import _04_Polymorphism_Exercises._03_WildFarm.Animals.Cat;
import _04_Polymorphism_Exercises._03_WildFarm.Animals.Mouse;
import _04_Polymorphism_Exercises._03_WildFarm.Animals.Tiger;
import _04_Polymorphism_Exercises._03_WildFarm.Animals.Zebra;
import _04_Polymorphism_Exercises._03_WildFarm.Foods.Food;
import _04_Polymorphism_Exercises._03_WildFarm.Foods.Meat;
import _04_Polymorphism_Exercises._03_WildFarm.Foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] animalTokens = scan.readLine().split("\\s+");
            if (animalTokens[0].equals("End")) break;
            String[] foodTokens = scan.readLine().split("\\s+");
            Food food = null;
            switch (foodTokens[0]) {
                case "Meat":
                    food = new Meat(Integer.valueOf(foodTokens[1]));
                    break;
                case "Vegetable":
                    food = new Vegetable(Integer.valueOf(foodTokens[1]));
                    break;
                default:
                    break;
            }

            String animalName = animalTokens[1];
            Double animalWeight = Double.valueOf(animalTokens[2]);
            String animalLivingRegion = animalTokens[3];

            switch (animalTokens[0].toLowerCase()) {
                case "mouse":
                    Mouse mikiMouse = new Mouse(animalName, animalWeight , animalLivingRegion);
                    mikiMouse.makeSound();
                    mikiMouse.eat(food);
                    System.out.println(mikiMouse);
                    break;
                case "zebra":
                    Zebra pesho = new Zebra(animalName, animalWeight, animalLivingRegion);
                    pesho.makeSound();
                    pesho.eat(food);
                    System.out.println(pesho);
                    break;
                case "cat":
                    String breed = animalTokens[4];
                    Cat gonzo = new Cat(animalName, animalWeight, animalLivingRegion, breed);
                    gonzo.makeSound();
                    gonzo.eat(food);
                    System.out.println(gonzo);
                    break;
                case "tiger":
                    Tiger gosho = new Tiger(animalName, animalWeight, animalLivingRegion);
                    gosho.makeSound();
                    gosho.eat(food);
                    System.out.println(gosho);
                    break;
                default:
                    break;
            }
        }
    }
}