package exams.exam_05_Jan_2018.colonists.engineers;

public class SoftwareEngineer extends Engineer {
    private static final int CLASS_BONUS = 3;
    private static final int AGE_BONUS = 2;

    public SoftwareEngineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        return this.getTalent()+ AGE_BONUS + CLASS_BONUS;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
