package _03_Inheritance_Exercises._06_Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
    }

    public void setName(String name) {
        if(name.length() < 1  || name.charAt(0) == ' '){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if(gender.length() <1 || gender.charAt(0) == ' '){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    protected String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + System.lineSeparator()
                + this.getName() + " " + this.getAge() + " " + this.getGender();
    }
}
