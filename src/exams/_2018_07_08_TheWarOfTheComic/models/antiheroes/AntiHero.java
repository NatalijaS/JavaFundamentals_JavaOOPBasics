package exams._2018_07_08_TheWarOfTheComic.models.antiheroes;

import exams._2018_07_08_TheWarOfTheComic.models.ComicCharacterImpl;

public abstract class AntiHero extends ComicCharacterImpl {

    private double evilness;

    protected AntiHero(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence);
        this.setEvilness(evilness);
    }

    private void setEvilness(double evilness) {
        if(evilness < 0.0){
            throw new IllegalArgumentException("Evilness should be a possitive number!");
        }
        this.evilness = evilness;
    }

    @Override
    public double getSpecial() {
        return this.evilness;
    }

    @Override
    public String toString() {
        String sb = String.format("###Evilness: %.2f", this.evilness) + System.lineSeparator();
        return super.toString() + sb;
    }
}
