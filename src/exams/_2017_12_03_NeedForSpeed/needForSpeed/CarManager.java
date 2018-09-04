package exams._2017_12_03_NeedForSpeed.needForSpeed;

import exams._2017_12_03_NeedForSpeed.needForSpeed.models.cars.Car;
import exams._2017_12_03_NeedForSpeed.needForSpeed.models.cars.PerformanceCar;
import exams._2017_12_03_NeedForSpeed.needForSpeed.models.cars.ShowCar;
import exams._2017_12_03_NeedForSpeed.needForSpeed.models.garage.Garage;
import exams._2017_12_03_NeedForSpeed.needForSpeed.models.races.CasualRace;
import exams._2017_12_03_NeedForSpeed.needForSpeed.models.races.DragRace;
import exams._2017_12_03_NeedForSpeed.needForSpeed.models.races.DriftRace;
import exams._2017_12_03_NeedForSpeed.needForSpeed.models.races.Race;

import java.util.LinkedHashMap;
import java.util.Map;

public class CarManager {

    private Map<Integer, Car> cars;
    private Map<Integer, Race> races;
    private Garage garage;

    public CarManager() {
        this.cars = new LinkedHashMap<>();
        this.races = new LinkedHashMap<>();
        this.garage = new Garage();
    }

    void register(int id, String type, String brand, String model, int yearOfProduction,
                  int horsepower, int acceleration, int suspension, int durability) {
        switch (type){
            case "Performance":
                this.cars.put(id, new PerformanceCar(brand, model, yearOfProduction, horsepower,
                        acceleration, suspension, durability));
                break;
            case "Show":
                this.cars.put(id, new ShowCar(brand, model, yearOfProduction, horsepower,
                        acceleration, suspension, durability));
                break;
        }

    }

    String check(int id) {
        return this.cars.get(id).toString();
    }

    void open(int id, String type, int length, String route, int prizePool) {

        switch (type){
            case "Casual":
                this.races.put(id, new CasualRace(length, route, prizePool));
                break;
            case "Drag":
                this.races.put(id, new DragRace(length, route, prizePool));
                break;
            case "Drift":
                this.races.put(id, new DriftRace(length, route, prizePool));
                break;
        }
    }

    void participate(int carId, int raceId){
        Car car = this.cars.get(carId);
        if(!this.garage.getParkedCars().contains(car)){
            this.races.get(raceId).addCar(car);
        }
    }

    String start(int id){
        Race race = this.races.get(id);
        if (race.getParticipants().isEmpty()) {
            return "Cannot start the race with zero participants.";
        }

        return race.toString();
    }

    void park(int id){
        Car car = this.cars.get(id);
        boolean isInRace = false;

        for (Race race : races.values()) {
            if(race.getParticipants().contains(car)){
                isInRace = true;
            }
        }

        if(!isInRace){
            this.garage.park(car);
        }
    }

    void unpark(int id){
        Car car = this.cars.get(id);
        this.garage.unPark(car);
    }

    void tune(int tuneIndex, String addOn){
        if(!garage.getParkedCars().isEmpty()){
            this.garage.tune(tuneIndex, addOn);
        }
    }
}
