package _03_Inheritance_Exercises._06_Animals;

public class Dog extends Animal{

    public Dog(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    protected String produceSound(){
        return "BauBau";
    }
}
