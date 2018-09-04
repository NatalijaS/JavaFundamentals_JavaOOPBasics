package exams._2018_01_05_TheExpanse.expance.colonists;

public abstract class Colonist {

    private String id;
    private String familyId;
    private int talent;
    private int age;

    public Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getFamilyId() {
        return familyId;
    }

    public int getTalent() {
        return talent;
    }

    public int getAge() {
        return age;
    }

    public void grow(int years) {
        this.age += years;
    }

    public int getPotential(){
        return this.getTalent() + this.getBonus();
    }

    protected abstract int getBonus();

    @Override
    public String toString() {
       return this.id + ": " + this.getPotential();
    }
}
