package exams._2018_07_08_TheWarOfTheComic.models.heroes;

import exams._2018_07_08_TheWarOfTheComic.models.ComicCharacterImpl;

public abstract class Hero extends ComicCharacterImpl{

    private double heroism;

    protected Hero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence);
        this.setHeroism(heroism);
    }

    public void setHeroism(double heroism) {
        if(heroism < 0.0){
            throw new IllegalArgumentException("Heroism should be a possitive number!");
        }
        this.heroism = heroism;
    }

    @Override
    public double getSpecial() {
        return this.heroism;
    }

    @Override
    public String toString() {
        String sb = String.format("###Heroism: %.2f", this.heroism) + System.lineSeparator();
        return super.toString() + sb;
    }
}
