package exams._2018_01_05_TheExpanse.expance.colonists.engineers;

import exams._2018_01_05_TheExpanse.expance.colonists.Colonist;

public abstract class Engineer extends Colonist {

    private static final int MIN_AGE = 30;
    private static final int FULL_BONUS = 5;
    private static final int PARTIAL_BONUS = 3;

   protected Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    protected int getBonus() {
        return super.getAge() > MIN_AGE ? FULL_BONUS : PARTIAL_BONUS;
    }
}
