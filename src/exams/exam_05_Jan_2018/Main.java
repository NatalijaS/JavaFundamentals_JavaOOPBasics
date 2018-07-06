package exams.exam_05_Jan_2018;

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
                    try {
                        if (inputArgs.length == 7) {
                            manager.insert(inputArgs[1], inputArgs[2], inputArgs[3],
                                    Integer.parseInt(inputArgs[4]), Integer.parseInt(inputArgs[5]), inputArgs[6]);
                        } else {
                            manager.insert(inputArgs[1], inputArgs[2], inputArgs[3],
                                    Integer.parseInt(inputArgs[4]), Integer.parseInt(inputArgs[5]));
                        }
                    }catch (IllegalStateException ise){
                        System.out.println(ise.getMessage());
                    }
                    break;
                case "remove":
                    if(inputArgs.length == 4){
                        manager.remove(inputArgs[1], inputArgs[2], inputArgs[3]);
                    }else {
                        manager.remove(inputArgs[1], inputArgs[2]);
                    }
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
