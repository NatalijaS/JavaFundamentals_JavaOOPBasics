package exams._2018_07_08_TheWarOfTheComic.models;

import exams._2018_07_08_TheWarOfTheComic.contracts.ComicCharacter;
import exams._2018_07_08_TheWarOfTheComic.contracts.SuperPower;

import java.util.ArrayList;
import java.util.List;

public abstract class ComicCharacterImpl implements ComicCharacter {

    private String name;
    private int energy;
    private double health;
    private double intelligence;
    private List<SuperPower> powers;

    protected ComicCharacterImpl(String name, int energy, double health, double intelligence) {
        this.setName(name);
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
        this.powers = new ArrayList<>();
    }

    private void setName(String name) {
        if(!name.matches("[a-zA-Z_]+") || name.length() > 12 || name.length() < 2){
            throw new IllegalArgumentException("Comic Characters name is not in the correct format!");
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        if(energy < 0 || energy > 300){
            throw new IllegalArgumentException("Energy is not in the correct range!");
        }
        this.energy = energy;
    }

    private void setHealth(double health) {
        if(health < 0){
            throw new IllegalArgumentException("Health should be a possitive number!");
        }
        this.health = health;
    }

    private void setIntelligence(double intelligence) {
        if (intelligence < 0 || intelligence > 200){
            throw new IllegalArgumentException("Intelligence is not in the correct range!");
        }
        this.intelligence = intelligence;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public double getHealth() {
        return this.health;
    }

    @Override
    public double getIntelligence() {
        return this.intelligence;
    }

    @Override
    public void takeDamage(double damage) {
        this.health -= damage;
    }

    @Override
    public void boostCharacter(int energy, double health, double intelligence) {
        this.setEnergy(energy);
        this.setHealth(health);
        this.setIntelligence(intelligence);
    }

    @Override
    public String useSuperPowers() {
        if (this.powers.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s has no super powers!", this.name));
        }
        for (SuperPower power : this.powers) {
            double powerPoints = power.getPowerPoints();
            this.energy += powerPoints;
            this.health += powerPoints * 2;
        }
        return String.format("%s used his super powers!", this.name);
    }

    @Override
    public void addSuperPower(SuperPower superPower) {
        this.powers.add(superPower);
    }

    @Override
    public String toString() {
        return String.format("#Name: %s", this.name) +
                System.lineSeparator() +
                String.format("##Health: %.2f// Energy: %d// Intelligence: %.2f"
                        , this.health, this.energy, this.intelligence) +
                System.lineSeparator();
    }
}
