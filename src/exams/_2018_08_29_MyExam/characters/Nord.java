package exams._2018_08_29_MyExam.characters;

public class Nord extends Endurance {

    private static final String HERO_TYPE = "NORD";

    public Nord(String name, int magicka, int fatigue, int health) {
        super(name, magicka, fatigue, health, HERO_TYPE);
    }
}
