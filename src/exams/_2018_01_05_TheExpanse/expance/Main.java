package exams._2018_01_05_TheExpanse.expance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String [] colonyArgs = reader.readLine().split("\\s+");
        int maxFamilyCount = Integer.parseInt(colonyArgs[0]);
        int maxFamilyCapacity = Integer.parseInt(colonyArgs[1]);

        ColonyManager manager = new ColonyManager(maxFamilyCount, maxFamilyCapacity);

        String input;
        while (!"end".equals(input = reader.readLine())){
            String [] inputArgs = input.split("\\s+");
            String command = inputArgs[0];
            switch (command){
                case "insert":
                    manager.insert(inputArgs);
                    break;
                case "remove":
                    manager.remove(inputArgs);
                    break;
                case "grow":
                    manager.grow(Integer.parseInt(inputArgs[1]));
                    break;
                case "potential":
                    System.out.println(manager.potential());
                    break;
                case "capacity":
                    System.out.println(manager.capacity());
                    break;
                case "family":
                    System.out.println(manager.family(inputArgs[1]));
                    break;
            }
        }
    }
}
