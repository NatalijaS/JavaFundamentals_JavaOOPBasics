package exams.exam_05_Jan_2018.colonists.engineers;

import exams.exam_05_Jan_2018.colonists.Colonist;

public abstract class Engineer extends Colonist {

    public Engineer(String id, String familyId, int talent, int age) {
        super(id, familyId, talent, age);
    }

    @Override
    public abstract int getPotential() ;
    @Override
    public String toString() {
        return super.toString();
    }
}
