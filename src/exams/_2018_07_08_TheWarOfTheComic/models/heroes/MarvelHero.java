package exams._2018_07_08_TheWarOfTheComic.models.heroes;

public class MarvelHero extends Hero {

    public MarvelHero(String name, int energy, double health, double intelligence, double heroism) {
        super(name, energy, health, intelligence, heroism);
    }

    @Override
    public double attack() {
        return ((this.getEnergy() + this.getSpecial()) * this.getIntelligence()) / 2.5;
    }

    @Override
    public String toString() {
        String sb = String.format("####Marvel Attack Power: %.2f", this.attack());
        return super.toString() + sb;
    }
}
