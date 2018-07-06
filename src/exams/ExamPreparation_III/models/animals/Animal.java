package exams.ExamPreparation_III.models.animals;

public abstract class Animal {

    private String name;
    private int age;
    private boolean isCleansed;
    private String adoptionCenter;

    protected Animal(String name, int age, String adoptionCenter) {
        this(name, age);
        this.adoptionCenter = adoptionCenter;
    }

    protected Animal(String name, int age) {
        this.name = name;
        this.age = age;
        this.isCleansed = false;
    }

    public boolean isCleansed() {
        return isCleansed;
    }

    public void cleanse() {
        this.isCleansed = true;
    }

    public String getName() {
        return this.name;
    }

    public String getAdoptionCenter() {
        return this.adoptionCenter;
    }
}
