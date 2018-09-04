package exams._2018_08_29_MyExam.characters;

public class Khajiit extends Strength {

    private static final String HERO_TYPE = "KHAJIIT";

    public Khajiit(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, HERO_TYPE);
    }
}
