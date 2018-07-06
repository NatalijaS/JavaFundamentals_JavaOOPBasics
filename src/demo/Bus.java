package demo;

public class Bus extends Vehicle {
    private static final double FUEL_CONSUMPTION_MODIFIER = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    void driveEmpty(double kilometers) {
        Double consumption = kilometers * (this.getFuelConsumption());
        if (consumption > this.getFuelQuantity()) {
            throw new IllegalArgumentException(this.getClass().getSimpleName() + " needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity() - consumption);
    }

    @Override
    protected void setFuelQuantity(double fuelQuantity) {
        if (this.getTankCapacity() < fuelQuantity + this.getFuelQuantity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    public void drive(double kilometers) {
        Double consumption = kilometers * (this.getFuelConsumption() + FUEL_CONSUMPTION_MODIFIER);
        if (consumption > this.getFuelQuantity()) {
            throw new IllegalArgumentException("Bus needs refueling");
        }
        this.setFuelQuantity(this.getFuelQuantity() - consumption);
    }

}
