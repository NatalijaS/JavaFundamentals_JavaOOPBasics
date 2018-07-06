package demo;

public class Car extends Vehicle {
    private static final double FUEL_CONSUMPTION_MODIFIER = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    protected void setFuelQuantity(double fuelQuantity) {
        if(this.getTankCapacity() < fuelQuantity + this.getFuelQuantity()){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    public void drive(double kilometers) {
        Double consumption = kilometers * (this.getFuelConsumption() + FUEL_CONSUMPTION_MODIFIER);
        if (consumption > this.getFuelQuantity()) {
            throw new IllegalArgumentException("Car needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity() - consumption);
    }
}
