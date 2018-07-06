package _02_Encapsulation_Exercises._05_pizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Toppings implements Eatable {
    private static final int CALORIES_PER_GRAM = 2;
    private static final Map<String, Double> MODIFIERS = new HashMap<String, Double>() {{
        put("Meat", 1.2);
        put("Veggies", 0.8);
        put("Cheese", 1.1);
        put("Sauce", 0.9);
    }};

    private double weight;
    private double modifier;

    public Toppings(String type, double weight) {
        this.setModifier(type);
        this.setWeight(weight, type);
    }

    private void setModifier(String type) {
        if (!MODIFIERS.containsKey(type)) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.modifier = MODIFIERS.get(type);
    }

    private void setWeight(double weight, String type) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", type));
        }
        this.weight = weight;
    }

    @Override
    public double getTotalCalories() {
        return (CALORIES_PER_GRAM * this.weight) * this.modifier;
    }
}
