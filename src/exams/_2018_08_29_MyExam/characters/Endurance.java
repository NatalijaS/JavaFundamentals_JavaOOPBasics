package exams._2018_08_29_MyExam.characters;

public  class Endurance extends Characters {

    private double magicResistance;
    private String sign;

    public Endurance(String name, int magicka, int fatigue, int health, String heroType) {
        super(name, magicka, fatigue, health * 2, heroType);
        this.magicResistance = super.getMagicka() * 0.4;
        this.sign = "Endurance";
    }

    public String getSign() {
        return sign;
    }

    @Override
    public double getSpecial() {
        return this.magicResistance;
    }

    @Override
    public double getOffense() {
        //the fatigue of the hero
        return super.getFatigue();
    }

    @Override
    public double getDefense() {
        //the health of the hero + 60% of the hero`s fatigue + the hero`s magic resistance
        return super.getHealth() + super.getFatigue() * 0.6 + this.getSpecial();
    }
}
