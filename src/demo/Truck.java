package demo;

public class Truck extends Vehicle{
    private static final double FUEL_CONSUMPTION_MODIFIER = 1.6;


    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public void drive(double kilometers) {
        Double consumption = kilometers * (this.getFuelConsumption() + FUEL_CONSUMPTION_MODIFIER);
        if (consumption > this.getFuelQuantity()) {
            throw new IllegalArgumentException("Truck needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity() - consumption);
    }

    @Override
    public void refuel(double liters) {
        liters -= liters * 0.05;
        super.refuel(liters);
    }
}
