package _01_DefiningClasses_Exercises._09_google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemonList;

    public Person(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    void addPokemon(Pokemon pokemon) {
        if (!this.pokemonList.contains(pokemon)) {
            this.pokemonList.add(pokemon);
        }
    }

    void addParent(Parent parent) {
        if (!this.parents.contains(parent)) {
            this.parents.add(parent);
        }
    }

    void addChild(Child child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.name).append(System.lineSeparator());
        output.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            output.append(this.company).append(System.lineSeparator());
        }
        output.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            output.append(this.car).append(System.lineSeparator());
        }
        output.append("Pokemon:").append(System.lineSeparator());
        this.pokemonList.forEach(pokemon -> output.append(pokemon).append(System.lineSeparator()));
        output.append("Parents:").append(System.lineSeparator());
        this.parents.forEach(parent -> output.append(parent).append(System.lineSeparator()));
        output.append("Children:").append(System.lineSeparator());
        this.children.forEach(child -> output.append(child).append(System.lineSeparator()));
        return output.toString();
    }
}
