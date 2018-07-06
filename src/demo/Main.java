package demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carTokens = reader.readLine().split("\\s+");
        String[] truckTokens = reader.readLine().split("\\s+");
        String[] busTokens = reader.readLine().split("\\s+");
        int numberOfCommands = Integer.parseInt(reader.readLine());

        Car car = new Car(Double.valueOf(carTokens[1]), Double.valueOf(carTokens[2]), Double.valueOf(carTokens[3]));
        Truck truck = new Truck(Double.valueOf(truckTokens[1]), Double.valueOf(truckTokens[2]), Double.valueOf(truckTokens[3]));
        Bus bus = new Bus(Double.valueOf(busTokens[1]), Double.valueOf(busTokens[2]), Double.valueOf(busTokens[3]));
        for (int i = 0; i < numberOfCommands; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            try {
                switch (tokens[0]) {
                    case "Drive":
                        switch (tokens[1]) {
                            case "Car":
                                car.drive(Double.parseDouble(tokens[2]));
                                break;
                            case "Truck":
                                truck.drive(Double.parseDouble(tokens[2]));
                                break;
                            case "Bus":
                                bus.drive(Double.parseDouble(tokens[2]));
                                break;
                        }
                        break;
                    case "Refuel":
                        switch (tokens[1]) {
                            case "Car":
                                car.refuel(Double.parseDouble(tokens[2]));
                                break;
                            case "Truck":
                                truck.refuel(Double.parseDouble(tokens[2]));
                                break;
                            case "Bus":
                                bus.refuel(Double.parseDouble(tokens[2]));
                                break;
                        }
                        break;
                    case "DriveEmpty":
                        bus.driveEmpty(Double.parseDouble(tokens[2]));
                        break;
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
