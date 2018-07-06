package _02_Encapsulation_Exercises._05_pizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            Pizza pizza;
            String[] tokens1 = reader.readLine().split("\\s+");
            String pizzaName = tokens1[1];
            int numberOfToppings = Integer.parseInt(tokens1[2]);
            pizza = new Pizza(pizzaName, numberOfToppings);

            String[] tokens2 = reader.readLine().split("\\s+");
            String flourType = tokens2[1];
            String bakingTechnique = tokens2[2];
            double weightOfDough = Double.parseDouble(tokens2[3]);
            Eatable dough = new Dough(flourType, bakingTechnique, weightOfDough);
            pizza.addIngredient(dough);

            for (int i = 0; i < pizza.getNumberOfToppings(); i++) {
                String[] tokens = reader.readLine().split("\\s+");
                String type = tokens[1];
                double weightOfTopping = Double.parseDouble(tokens[2]);
                Eatable topping = new Toppings(type, weightOfTopping);
                pizza.addIngredient(topping);
            }

            System.out.println(pizza);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
