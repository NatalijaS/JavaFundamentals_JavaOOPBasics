package _02_Encapsulation_Exercises._05_pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private int numberOfToppings;
    private List<Eatable> ingredients;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setNumberOfToppings(numberOfToppings);
        this.ingredients = new ArrayList<>();
    }

    private void setNumberOfToppings(int numberOfToppings) {
        if (numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = numberOfToppings;
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.trim().length() == 0 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    int getNumberOfToppings() {
        return this.numberOfToppings;
    }

    void addIngredient(Eatable eatable) {
        this.ingredients.add(eatable);
    }

    private double getTotalCalories() {
        return this.ingredients.stream()
                .map(Eatable::getTotalCalories)
                .reduce(0.0, (a, b) -> a + b);
    }

    @Override
    public String toString() {
        return String.format("%s - %.2f", this.name, this.getTotalCalories());
    }
}
