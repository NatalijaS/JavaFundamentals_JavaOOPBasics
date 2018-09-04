package exams._2018_08_29_MyExam.characters;

import interfaces.Hero;

public abstract class Characters implements Hero, Comparable<Hero>{

    private String name;
    private int magicka;
    private int fatigue;
    private int health;
    private String heroType;

    public Characters(String name, int magicka, int fatigue, int health, String heroType) {
        this.name = name;
        this.magicka = magicka;
        this.fatigue = fatigue;
        this.health = health;
        this.heroType = heroType;
    }

    public int getMagicka() {
        return magicka;
    }

    public int getFatigue() {
        return fatigue;
    }

    public String getHeroType() {
        return heroType;
    }

    public double getSpecial(){
        return 0;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public abstract double getOffense();

    @Override
    public abstract double getDefense();

    @Override
    public double getTotalPoints() {
        return this.getOffense() + this.getDefense();
    }


    @Override
    public boolean isDead() {
        return this.health < 1;
    }

    @Override
    public void attack(Hero hero) {
        this.health -= Math.floor(hero.getOffense());
    }

    @Override
    public void receiveDamage(double amount) {
        this.health -= Math.floor(amount);
    }

    @Override
    public String toString() {
        //Hero: {heroName}, Offense: {offense}, Defense: {defense}
        return String.format("Hero: %s, Offense: %.2f, Defense: %.2f",
                this.getName(), this.getOffense(), this.getDefense());
    }

    @Override
    public int compareTo(Hero o) {
        return Double.compare(o.getTotalPoints(), this.getTotalPoints());
    }
}
