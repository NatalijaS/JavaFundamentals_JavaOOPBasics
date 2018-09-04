package exams._2018_07_08_TheWarOfTheComic.models.antiheroes;

public class Villain extends AntiHero {

    public Villain(String name, int energy, double health, double intelligence, double evilness) {
        super(name, energy, health, intelligence, evilness);
    }

    @Override
    public double attack() {
        return (super.getIntelligence() * super.getSpecial()) / super.getEnergy();
    }

    @Override
    public String toString() {
        String sb = String.format("####Villain Attack Power: %.2f", this.attack());
        return super.toString() + sb;
    }
}
