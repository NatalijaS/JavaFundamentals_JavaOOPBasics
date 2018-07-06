package exams.ExamPreparation_II.models.races;

import exams.ExamPreparation_II.models.cars.Car;

public class DriftRace extends Race {

    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public int calculatePoints(Car car) {
        return car.getSuspension() + car.getDurability();
    }
}
