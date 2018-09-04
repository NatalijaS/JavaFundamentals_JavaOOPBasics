package exams._2018_08_29_MyExam.characters;

public class Redguard extends Strength {

    private static final String HERO_TYPE = "REDGUARD";

    public Redguard(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, HERO_TYPE);
    }
}
