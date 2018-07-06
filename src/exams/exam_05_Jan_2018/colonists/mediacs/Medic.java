package exams.exam_05_Jan_2018.colonists.mediacs;

import exams.exam_05_Jan_2018.colonists.Colonist;

public abstract class Medic extends Colonist{
    private String  sign;
    public Medic(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age);
        this.setSign(sign);
    }

    public String getSign() {
        return sign;
    }

    private void setSign(String sign) {
        this.sign = sign;
    }

    @Override
    public abstract int getPotential();

    @Override
    public String toString() {
        return "Medic{" +
                "sign='" + sign + '\'' +
                '}';
    }
}
