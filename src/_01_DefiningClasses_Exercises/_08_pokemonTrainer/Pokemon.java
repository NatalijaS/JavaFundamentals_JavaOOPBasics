package _01_DefiningClasses_Exercises._08_pokemonTrainer;

public class Pokemon {
    private String name;
    private String element;
    private double health;

    Pokemon(String name, String element, double health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    String getElement() {
        return this.element;
    }

    void reduceHealth() {
        this.health -= 10;
    }

    boolean isAlive() {
        return this.health > 0;
    }
}
