package _04_Polymorphism_Exercises._01_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split("\\s+");
        String[] truckTokens = reader.readLine().split("\\s+");
        int numberOfCommands = Integer.parseInt(reader.readLine());
        Vehicle car = new Car(Double.valueOf(carTokens[1]), Double.valueOf(carTokens[2]));
        Vehicle truck = new Truck(Double.valueOf(truckTokens[1]), Double.valueOf(truckTokens[2]));

        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandTokens = reader.readLine().split("\\s+");
            try {
                if (commandTokens[0].toLowerCase().equals("drive")) {
                    if (commandTokens[1].toLowerCase().equals("car")) {
                        car.drive(Double.valueOf(commandTokens[2]));
                    } else {
                        truck.drive(Double.valueOf(commandTokens[2]));
                    }
                    DecimalFormat df = new DecimalFormat("#.#########################");
                    System.out.println(commandTokens[1] + " travelled " + df.format(Double.valueOf(commandTokens[2])) + " km");
                } else {
                    if (commandTokens[1].toLowerCase().equals("car")) {
                        car.refuel(Double.valueOf(commandTokens[2]));
                    } else {
                        truck.refuel(Double.valueOf(commandTokens[2]));
                    }
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
    }
}
