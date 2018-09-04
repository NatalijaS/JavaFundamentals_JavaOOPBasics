package exams._2018_07_08_TheWarOfTheComic.models.antiheroes;

public class Titan extends AntiHero {

    public Titan(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return  (super.getEnergy() + super.getIntelligence() + super.getSpecial()) * 3;
    }

    @Override
    public String toString() {
        String sb = String.format("####Titan Attack Power: %.2f", this.attack());
        return super.toString() + sb;
    }
}
