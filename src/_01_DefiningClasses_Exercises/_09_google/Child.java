package _01_DefiningClasses_Exercises._09_google;

public class Child {
    private String name;
    private String birthDate;

    Child(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthDate);
    }}
