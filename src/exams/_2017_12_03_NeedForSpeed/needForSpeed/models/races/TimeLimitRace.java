package exams._2017_12_03_NeedForSpeed.needForSpeed.models.races;

import exams._2017_12_03_NeedForSpeed.needForSpeed.models.cars.Car;

public class TimeLimitRace extends Race {

    private int goldTime;

    public TimeLimitRace(int length, String route, int prizePool, int goldTime) {
        super(length, route, prizePool);
        this.goldTime = goldTime;
    }

    @Override
    protected int calculatePoints(Car car) {
        int points = super.getLength() * ((car.getHorsepower() / 100) * car.getAcceleration());
        return points;
    }

    @Override
    public String toString() {
        Car car = super.getParticipants().get(0);
        int points = this.calculatePoints(car);
        String earnedTime;
        int prize;
        if (points <= this.goldTime) {
            earnedTime = "Gold";
            prize = super.getPrizePool();
        } else if (points <= this.goldTime + 15) {
            earnedTime = "Silver";
            prize = (super.getPrizePool() * 50) / 100;
        } else {
            earnedTime = "Bronze";
            prize = (super.getPrizePool() * 30) / 100;
        }

        return String.format("%s - %s", super.getRoute(), super.getLength()) +
                System.lineSeparator() +
                String.format("%s %s - %d s.", car.getBrand(), car.getModel(), points) +
                System.lineSeparator() +
                String.format("%s Time, $%d.", earnedTime, prize);
    }
}
