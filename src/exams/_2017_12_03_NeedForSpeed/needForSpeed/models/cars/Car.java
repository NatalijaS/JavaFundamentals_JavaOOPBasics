package exams._2017_12_03_NeedForSpeed.needForSpeed.models.cars;

public abstract class Car {

    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower,
                  int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public void tuneCar(int index, String addOn) {
        this.horsepower += index;
        this.suspension += ((index * 50) / 100);
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    protected int getYearOfProduction() {
        return this.yearOfProduction;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    public void decreaseDurability(int laps, int length) {
        this.durability -= laps * Math.pow(length, 2);
    }

    @Override
    public String toString() {

        return String.format("%s %s %d", this.getBrand(), this.getModel(), this.getYearOfProduction()) +
                System.lineSeparator() +
                String.format("%d HP, 100 m/h in %d s", this.getHorsepower(), this.getAcceleration()) +
                System.lineSeparator() +
                String.format("%d Suspension force, %d Durability", this.getSuspension(), this.getDurability()) +
                System.lineSeparator();
    }
}
