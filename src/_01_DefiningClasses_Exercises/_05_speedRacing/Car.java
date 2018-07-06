package _01_DefiningClasses_Exercises._05_speedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostPer1Km;
    private double distanceTraveled;

    public Car() {
    }

    public Car(String model, double fuelAmount, double fuelCostPer1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1Km = fuelCostPer1Km;
        this.distanceTraveled = 0;
    }

    void moveCar(double amountOfKm){
        double fuelForDrive = amountOfKm * this.fuelCostPer1Km;
        if(fuelForDrive > fuelAmount){
            throw new IllegalStateException("Insufficient fuel for the drive");
        }
        this.distanceTraveled += amountOfKm;
        this.fuelAmount -= fuelForDrive;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d", this.model, this.fuelAmount, (int)this.distanceTraveled);
    }
}
