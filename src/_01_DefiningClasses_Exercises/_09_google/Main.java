package _01_DefiningClasses_Exercises._09_google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new HashMap<>();
        String input;
        while (!"End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");

            String name = tokens[0];
            people.putIfAbsent(name, new Person(name));
            setInformation(people, tokens, name);
        }

        String personName = reader.readLine();

        people.entrySet()
                .stream()
                .filter(p -> p.getValue().getName().equals(personName))
                .forEach(p -> System.out.print(p.getValue()));
    }

    private static void setInformation(Map<String, Person> people, String[] tokens, String name) {
        switch (tokens[1]){
            case "company":
                String companyName = tokens[2];
                String department = tokens[3];
                double salary = Double.parseDouble(tokens[4]);
                people.get(name).setCompany(new Company(companyName,department,salary));
                break;
            case "pokemon":
                String pokemonName = tokens[2];
                String pokemonType = tokens[3];
                people.get(name).addPokemon(new Pokemon(pokemonName, pokemonType));
                break;
            case "parents":
                String parentName = tokens[2];
                String parentBirthDate = tokens[3];
                people.get(name).addParent(new Parent(parentName, parentBirthDate));
                break;
            case "children":
                String childName = tokens[2];
                String childBirthDate = tokens[3];
                people.get(name).addChild(new Child(childName, childBirthDate));
                break;
            case "car":
                String carModel = tokens[2];
                String carSpeed = tokens[3];
                people.get(name).setCar(new Car(carModel,carSpeed));
                break;
        }
    }
}
