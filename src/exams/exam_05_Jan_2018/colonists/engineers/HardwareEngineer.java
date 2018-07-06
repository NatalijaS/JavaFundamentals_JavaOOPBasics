package exams.exam_05_Jan_2018.colonists.engineers;

public class HardwareEngineer extends Engineer{
    private static final int CLASS_BONUS = 3;
    private static final int AGE_BONUS = 2;

    public HardwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        if(this.getAge() < 18 || this.getAge() > 30){
            return this.getTalent() + CLASS_BONUS + AGE_BONUS;
        }
        return this.getTalent() + CLASS_BONUS ;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
