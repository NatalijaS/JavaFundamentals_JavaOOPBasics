package _03_Inheritance_Exercises._06_Animals;

public class Tomcat extends Cat {
    private static final String GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, GENDER);
    }

    @Override
    public String produceSound() {
        return "Give me one million b***h";
    }
}
