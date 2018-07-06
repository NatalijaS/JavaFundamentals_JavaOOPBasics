package exams.exam_05_Jan_2018.colonists;

public class Soldier extends Colonist {
    private static final int CLASS_BONUS = 3;
    private static final int AGE_BONUS = 3;

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public int getPotential() {
        return this.getTalent() + CLASS_BONUS + AGE_BONUS;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
