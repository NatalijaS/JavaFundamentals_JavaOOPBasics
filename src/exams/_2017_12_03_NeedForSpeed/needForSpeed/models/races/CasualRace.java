package exams._2017_12_03_NeedForSpeed.needForSpeed.models.races;

import exams._2017_12_03_NeedForSpeed.needForSpeed.models.cars.Car;

public class CasualRace extends Race {

    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public int calculatePoints(Car car) {
        return (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());
    }
}
