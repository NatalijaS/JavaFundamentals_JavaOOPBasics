package _01_DefiningClasses_Exercises._08_pokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input1;
        while (!"Tournament".equals(input1 = reader.readLine())) {
            String[] tokens = input1.split("\\s+");
            String trainer = tokens[0];
            String pokemonName = tokens[1];
            String element = tokens[2];
            int health = Integer.parseInt(tokens[3]);
            trainers.putIfAbsent(trainer, new Trainer(trainer));
            trainers.get(trainer).add(new Pokemon(pokemonName, element, health));
        }

        String input2;
        while (! "End".equals(input2 = reader.readLine())) {
            String element = input2;
            trainers.values().forEach(trainer -> trainer.processElement(element));
        }

        trainers.values()
                .stream()
                .sorted()
                .forEach(System.out::println);
    }
}
