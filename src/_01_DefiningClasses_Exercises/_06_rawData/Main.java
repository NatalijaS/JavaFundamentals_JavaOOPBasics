package _01_DefiningClasses_Exercises._06_rawData;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<Car> cars = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String [] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = new Engine(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            Cargo cargo = new Cargo(Double.parseDouble(tokens[3]), tokens[4]);
            Set<Tires> tires = new HashSet<>();
            for (int j = 5; j < tokens.length ; j += 2) {
                Tires tire= new Tires(Double.parseDouble(tokens[j]), Integer.parseInt(tokens[j+1]));
                tires.add(tire);
            }
            Car car = new Car(model, engine, cargo, tires);
            cars.add(car);
        }

        String command = scanner.nextLine();
        switch (command){
            case "fragile":
                cars.stream()
                        .filter(c -> c.getCargo().getCargoType().equals("fragile"))
                        .filter(c -> c.getTires().stream()
                                            .filter(tire -> tire.getTirePressure() < 1)
                                .collect(Collectors.toList()).size() > 0)
                        .forEach(System.out::println);
                break;
            case "flamable":
                cars.stream()
                        .filter(c -> c.getCargo().getCargoType().equals("flamable"))
                        .filter(c -> c.getEngine().getEnginePower() > 250)
                        .forEach(System.out::println);
                break;
        }
    }
}
