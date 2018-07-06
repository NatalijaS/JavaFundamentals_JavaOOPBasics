package _01_DefiningClasses_Exercises._02_creatingConstructors;

public class Person {
    public String name;
    public Integer age;

    public Person() {
        this.name = "No name";
        this.age = 1;
    }

    public Person(Integer age) {
        this.age = age;
        this.name = "No name";
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
