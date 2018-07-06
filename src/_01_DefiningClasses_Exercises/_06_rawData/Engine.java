package _01_DefiningClasses_Exercises._06_rawData;

class Engine{
    private int engineSpeed;
    private int enginePower;

    Engine(int engineSpeed, int enginePower) {
        this.engineSpeed = engineSpeed;
        this.enginePower = enginePower;
    }

    int getEnginePower() {
        return enginePower;
    }
}
