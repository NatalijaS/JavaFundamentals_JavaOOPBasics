package exams._2017_12_03_NeedForSpeed.needForSpeed.models.cars;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {

    private List<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower,
                          int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, (int)(horsepower * 1.5), acceleration,
                (int) (suspension - (suspension * 0.25)), durability);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void tuneCar(int index, String addOn) {
        super.tuneCar(index, addOn);
        this.addOns.add(addOn);
    }

    @Override
    public String toString() {
        StringBuilder performanceCar = new StringBuilder(super.toString());

        String addOns = this.addOns.size() == 0 ? "None" : String.join(", ", this.addOns);

        performanceCar
                .append(String.format("Add-ons: %s", addOns));

        return performanceCar.toString();
    }
}
