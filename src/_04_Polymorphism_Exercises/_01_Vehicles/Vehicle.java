package _04_Polymorphism_Exercises._01_Vehicles;

abstract class Vehicle {

    private final double FUEL_CONSUMPTION_INCREASE = this.getClass().getSimpleName().equals("Truck") ? 1.6 : 0.9;

    private double fuelQuantity;
    private double fuelConsumption;

    Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    private double getFuelQuantity() {
        return this.fuelQuantity;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private double getFuelConsumption() {
        return this.fuelConsumption;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    void drive(double kilometers) {
        Double consumption = kilometers * (this.getFuelConsumption() + FUEL_CONSUMPTION_INCREASE);
        if (consumption > this.getFuelQuantity()) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity() - consumption);
    }

    void refuel(double liters) {
        final double finalLiters = this.getClass().getSimpleName().equals("Truck") ? liters - (liters * 0.05) : liters;
        this.setFuelQuantity(this.getFuelQuantity() + finalLiters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
