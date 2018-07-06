package _01_DefiningClasses_Exercises._06_rawData;

import java.util.Set;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Set<Tires> tires;

    public Car(String model, Engine engine, Cargo cargo, Set<Tires> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    Engine getEngine() {
        return engine;
    }

    Cargo getCargo() {
        return cargo;
    }

    Set<Tires> getTires() {
        return tires;
    }

    @Override
    public String toString(){
        return this.model;
    }
}
