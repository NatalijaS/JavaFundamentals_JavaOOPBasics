package _01_DefiningClasses_Exercises._09_google;

public class Pokemon {
    private String name;
    private String type;

    Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.type);
    }
}
