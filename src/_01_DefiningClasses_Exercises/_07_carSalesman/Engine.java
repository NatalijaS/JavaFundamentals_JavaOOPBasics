package _01_DefiningClasses_Exercises._07_carSalesman;

public class Engine {
    private static final String DEFAULT_VALUE ="n/a";

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    Engine(String model, String power, String value) {
        this(model,power,DEFAULT_VALUE,DEFAULT_VALUE);
        if(value.matches("-?\\d+(\\.\\d+)?")){
            this.displacement = value;
        }else{
            this.efficiency = value;
        }
    }

    Engine(String model, String power) {
        this(model,power,DEFAULT_VALUE,DEFAULT_VALUE);
    }

    String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return this.model + ":\n" +
                "Power: " + this.power + "\n" +
                "Displacement: " + this.displacement + "\n" +
                "Efficiency: " + this.efficiency + "\n";
    }
}
