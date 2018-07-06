package _01_DefiningClasses_Exercises._05_speedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");

            String model = line[0];
            Car car = new Car(model, Double.parseDouble(line[1]), Double.parseDouble(line[2]));
            cars.putIfAbsent(model, car);
        }

        String line2 = scanner.nextLine();
        while (!"End".equals(line2)) {
            String[] tokens = line2.split("\\s+");
            String carModel = tokens[1];
            double amountOfKm = Double.parseDouble(tokens[2]);
           try{
               cars.get(carModel).moveCar(amountOfKm);
           }catch (IllegalStateException ise){
               System.out.println(ise.getMessage());
           }

            line2 = scanner.nextLine();
        }

        cars.values().forEach(System.out::println);
    }
}
