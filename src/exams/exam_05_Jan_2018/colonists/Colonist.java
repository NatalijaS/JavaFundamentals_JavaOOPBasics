package exams.exam_05_Jan_2018.colonists;

public abstract class Colonist {
    private String id;
    private String familyId;
    private int talent;
    private int age;

    public Colonist(String id, String familyId, int talent, int age) {
        this.setId(id);
        this.setFamilyId(familyId);
        this.setTalent(talent);
        this.setAge(age);
    }

    public abstract int getPotential();

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getFamilyId() {
        return familyId;
    }

    private void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public int getTalent() {
        return talent;
    }

    private void setTalent(int talent) {
        this.talent = talent;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public void grow(int years) {
        this.setAge(this.getAge() + years);
    }

    @Override
    public String toString() {
        return "Colonist{" +
                "id='" + id + '\'' +
                ", familyId='" + familyId + '\'' +
                ", talent=" + talent +
                ", age=" + age +
                '}';
    }
}
