package _03_Inheritance_Exercises._06_Animals;

public class Kitten extends Cat{
    private static final String GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
