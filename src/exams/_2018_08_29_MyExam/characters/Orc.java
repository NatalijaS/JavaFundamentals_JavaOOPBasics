package exams._2018_08_29_MyExam.characters;

public class Orc extends Endurance {

    private static final String HERO_TYPE = "ORSIMER";

    public Orc(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, HERO_TYPE);
    }

    @Override
    public double getDefense() {
        //additional defense equal to 10% of the birth signs’ defense
        return super.getDefense() * 0.1;
    }
}
