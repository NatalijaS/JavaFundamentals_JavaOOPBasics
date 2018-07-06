package exams.exam_05_Jan_2018.colonists.mediacs;

public class GeneralPractitioner extends Medic{
    private static final int AGE_BONUS = 1;
    private static final int CLASS_BONUS = 2;

    public GeneralPractitioner(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int signBonus = (this.getSign().equals("caring"))? 1 : -2;
        if(this.getAge() > 15){
            return this.getTalent() + CLASS_BONUS  + signBonus + AGE_BONUS;
        }

        return this.getTalent() + CLASS_BONUS  + signBonus;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
