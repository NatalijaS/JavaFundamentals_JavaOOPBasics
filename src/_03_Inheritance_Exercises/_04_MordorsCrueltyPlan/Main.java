package _03_Inheritance_Exercises._04_MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Hero gandalf = new Hero();
        String[] inputFoods = reader.readLine().split("\\s+");

        for (String inputFood : inputFoods) {
            gandalf.eatFood(inputFood);
        }

        gandalf.setMood();
        System.out.println(gandalf.getPoints());
        System.out.println(gandalf.getMood());
    }
}
