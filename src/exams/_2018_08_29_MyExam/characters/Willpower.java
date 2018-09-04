package exams._2018_08_29_MyExam.characters;


public class Willpower extends Characters {

    private double spellPentration;
    private String sign;

    public Willpower(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.spellPentration = super.getFatigue() * 0.2;
        this.sign = "Willpower";
    }

    public String getSign() {
        return sign;
    }

    public double getSpellPentration() {
        return spellPentration;
    }

    @Override
    public double getOffense() {
        //180% of the hero`s magicka + the hero`s spell penetration
        return super.getMagicka() * 1.8 + this.getSpellPentration();
    }

    @Override
    public double getDefense() {
        //the health of the hero
        return super.getHealth();
    }

}
