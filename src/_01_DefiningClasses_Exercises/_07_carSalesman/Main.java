package _01_DefiningClasses_Exercises._07_carSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> engines = new HashMap<>();
        int n1 = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n1; i++) {
            String [] line = reader.readLine().split("\\s+");

            Engine engine;
            if(line.length == 4){
                engine = new Engine(line[0], line[1], line[2], line[3]);
            }else if(line.length == 3){
                engine = new Engine(line[0], line[1], line[2]);
            }else{
                engine = new Engine(line[0], line[1]);
            }
            engines.putIfAbsent(engine.getModel(), engine);
        }

        Map<String,Car> cars = new LinkedHashMap<>();
        int n2 = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n2; i++) {
            String [] line = reader.readLine().split(" ");

            Car car;
            if(line.length == 4){
                car = new Car(line[0], engines.get(line[1]), line[2], line[3]);
            }else if(line.length == 3){
                car = new Car(line[0], engines.get(line[1]), line[2]);
            }else{
                car = new Car(line[0], engines.get(line[1]));
            }
            cars.putIfAbsent(car.getModel(), car);
        }

        cars.forEach((key, value) -> System.out.print(value));
    }
}
