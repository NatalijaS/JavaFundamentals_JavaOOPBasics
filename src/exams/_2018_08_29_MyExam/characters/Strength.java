package exams._2018_08_29_MyExam.characters;


public class Strength extends Characters {

    private double magicDamage;
    private String sign;

    public Strength(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health, heroType);
        this.magicDamage = super.getMagicka() * 0.50;
        this.sign = "Strength";
    }

    public String getSign() {
        return sign;
    }

    @Override
    public double getSpecial() {
        return this.magicDamage;
    }

    @Override
    public double getOffense() {
        //125% of the hero`s fatigue + 30% of the health + the hero`s magic damage
        return super.getFatigue() * 1.25 + super.getHealth() * 0.3 + this.getSpecial();
    }

    @Override
    public double getDefense() {
        //the hero`s health + 10% of the hero`s fatigue
        return super.getHealth() + super.getFatigue() * 0.1;
    }
}
