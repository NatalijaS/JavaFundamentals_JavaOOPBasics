package _01_DefiningClasses_Exercises._06_rawData;

class Tires {
    private double tirePressure;
    private int age;

    Tires(double tirePressure, int age) {
        this.tirePressure = tirePressure;
        this.age = age;
    }

    double getTirePressure() {
        return tirePressure;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
