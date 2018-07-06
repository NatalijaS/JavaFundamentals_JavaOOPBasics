package exams.exam_05_Jan_2018.colonists.mediacs;

public class Surgeon extends Medic{
    private static final int AGE_BONUS = 2;
    private static final int CLASS_BONUS = 2;

    public Surgeon(String id, String familyId, int talent, int age, String sign) {
        super(id, familyId, talent, age, sign);
    }

    @Override
    public int getPotential() {
        int signBonus = (this.getSign().equals("precise"))? 3 : -3;
        if(this.getAge() > 25 && this.getAge() < 35){
          return this.getTalent() + CLASS_BONUS  + signBonus + AGE_BONUS;
        }

        return this.getTalent() + CLASS_BONUS + signBonus;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
