package exams._2018_01_05_TheExpanse.expance.colonists;

public class Soldier extends Colonist {

    private static final int BONUS = 6;

    public Soldier(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getBonus() {
        return BONUS;
    }
}
