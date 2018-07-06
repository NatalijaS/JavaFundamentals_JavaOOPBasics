package _02_Encapsulation_Exercises._03_animalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String chickenName = reader.readLine();
        int chickenAge = Integer.parseInt(reader.readLine());
        Chicken chicken;
        try{
        chicken = new Chicken(chickenName, chickenAge);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }

        System.out.println(chicken);
    }
}
