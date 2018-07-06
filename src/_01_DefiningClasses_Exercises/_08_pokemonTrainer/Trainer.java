package _01_DefiningClasses_Exercises._08_pokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer implements Comparable<Trainer>{
   private String name;
   private int numberOfBadges;
   private List<Pokemon> pokemonList;

    Trainer(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
        int numberOfBadges = 0;
    }

    private int getBadgesCount() {
        return this.numberOfBadges;
    }

    public String getName() {
        return this.name;
    }

    private int getPokemonListSize() {
        return this.pokemonList.size();
    }

    void add(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    void processElement(String element) {
        if (isPokemon(element)) {
            this.numberOfBadges++;
        } else {
            pokemonList.forEach(Pokemon::reduceHealth);
            this.pokemonList = this.pokemonList.stream()
                    .filter(Pokemon::isAlive)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
    }

    private boolean isPokemon(String element) {
        return this.pokemonList.stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
    }

    @Override
    public int compareTo(Trainer other) {
        return Integer.compare(other.getBadgesCount(), this.getBadgesCount());
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.getName(), this.getBadgesCount(), this.getPokemonListSize());
    }
}
