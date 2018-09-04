package exams._2018_01_05_TheExpanse.expance.colonists.mediacs;

import exams._2018_01_05_TheExpanse.expance.colonists.Colonist;

public abstract class Medic extends Colonist{

    private static final int BONUS = 2;

    private String  sign;

    protected Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    @Override
    protected int getBonus() {
        return BONUS;
    }
}
