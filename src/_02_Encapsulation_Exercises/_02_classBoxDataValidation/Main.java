package _02_Encapsulation_Exercises._02_classBoxDataValidation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        Box box;
        try{
         box = new Box(length, width, height);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }

        System.out.printf("Surface Area - %.2f%n",box.getSurfaceArea());
        System.out.printf("Lateral Surface Area - %.2f%n",box.getLateralSurfaceArea());
        System.out.printf("Volume - %.2f%n",box.getVolume());
    }
}
