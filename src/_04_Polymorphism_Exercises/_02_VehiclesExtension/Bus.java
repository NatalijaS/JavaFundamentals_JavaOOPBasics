package _04_Polymorphism_Exercises._02_VehiclesExtension;

class Bus extends Vehicle {

    Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    void driveEmpty(double kilometers) {
        Double consumption = kilometers * (this.getFuelConsumption());
        if (consumption > this.getFuelQuantity()) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity() - consumption);
    }
}
