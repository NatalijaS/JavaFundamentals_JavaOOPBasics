package exams._2016_10_07_SystemSplit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TheSystem system = new TheSystem();
        String command;

        while (!"System Split".equals(command = reader.readLine())) {
            String[] commandArgs = command.split("\\(|, |\\)");
            String commandType = commandArgs[0];

            switch (commandType) {
                case "RegisterPowerHardware":
                    system.registerPowerHardware(commandArgs[1], Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3]));
                    break;
                case "RegisterHeavyHardware":
                    system.registerHeavyHardware(commandArgs[1], Integer.parseInt(commandArgs[2]), Integer.parseInt(commandArgs[3]));
                    break;
                case "RegisterLightSoftware":
                    system.registerLightSoftware(commandArgs[1], commandArgs[2], Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[4]));
                    break;
                case "RegisterExpressSoftware":
                    system.registerExpressSoftware(commandArgs[1], commandArgs[2], Integer.parseInt(commandArgs[3]), Integer.parseInt(commandArgs[4]));
                    break;
                case "ReleaseSoftwareComponent":
                    system.releaseSoftwareComponent(commandArgs[1], commandArgs[2]);
                    break;
                case "Dump":
                    system.dump(commandArgs[1]);
                    break;
                case "Restore":
                    system.restore(commandArgs[1]);
                    break;
                case "Destroy":
                    system.destroy(commandArgs[1]);
                    break;
                case "DumpAnalyze":
                    system.dumpAnalyze();
                    break;
                case "Analyze":
                    System.out.println(system.analyze());
                    break;
            }
        }

        System.out.println(system.split());
    }
}
