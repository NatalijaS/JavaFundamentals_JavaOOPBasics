package _02_Encapsulation_Exercises._05_pizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Dough implements Eatable {
    private static final int CALORIES_PER_GRAM = 2;
    private static final Map<String, Double> MODIFIERS = new HashMap<String, Double>() {{
        put("White", 1.5);
        put("Wholegrain", 1.0);
        put("Crispy", 0.9);
        put("Chewy", 1.1);
        put("Homemade", 1.0);
    }};
    private double flourTypeModifier;
    private double bakingTechniqueModifier;
    private double weightInGrams;

    public Dough(String flourType, String bakingTechnique, double weightInGrams) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeightInGrams(weightInGrams);
    }

    private void setFlourType(String flourType) {
        if (!MODIFIERS.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourTypeModifier = MODIFIERS.get(flourType);
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!MODIFIERS.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechniqueModifier = MODIFIERS.get(bakingTechnique);
    }

    private void setWeightInGrams(double weightInGrams) {
        if (weightInGrams < 1 || weightInGrams > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weightInGrams = weightInGrams;
    }

    @Override
    public double getTotalCalories() {
        return (CALORIES_PER_GRAM * this.weightInGrams) * this.flourTypeModifier * this.bakingTechniqueModifier;
    }
}
