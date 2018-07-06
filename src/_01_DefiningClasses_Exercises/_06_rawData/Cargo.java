package _01_DefiningClasses_Exercises._06_rawData;

class Cargo {
    private double cargoPressure;
    private String cargoType;

    Cargo(double cargoPressure, String cargoType) {
        this.cargoPressure = cargoPressure;
        this.cargoType = cargoType;
    }

    String getCargoType() {
        return cargoType;
    }
}
