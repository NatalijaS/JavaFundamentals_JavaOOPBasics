package exams._2018_08_29_MyExam;

import exams._2018_08_29_MyExam.interfaces.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {

    private BufferedReader reader;
    private ProvinceManager provinceManager;

    public Engine( ProvinceManager provinceManager) {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.provinceManager = provinceManager;
    }

    @Override
    public void run() throws IOException {
        String line;
        while (!"END".equals(line = reader.readLine())){
            String[] commandTokens = line.split("\\s+");
            switch (commandTokens[0]){
                case "CREATE_PROVINCE:":
                    System.out.println(provinceManager.createProvince(commandTokens[1]));
                    System.out.println("---");
                    break;
                case "SELECT:":
                    System.out.println(provinceManager.selectProvince(commandTokens[1]));
                    System.out.println("---");
                    break;
                case "ADD_HERO:":
                    System.out.println(provinceManager.addHero(commandTokens[1], commandTokens[2], commandTokens[3]
                            , Integer.parseInt(commandTokens[4]), Integer.parseInt(commandTokens[5]), Integer.parseInt(commandTokens[6])));
                    System.out.println("---");
                    break;
                case "ADD_GUILD:":
                    System.out.println(provinceManager.addGuild(commandTokens[1]));
                    System.out.println("---");
                    break;
                case "DETAILS:":
                    System.out.println(provinceManager.details(commandTokens));
                    System.out.println("---");
                    break;
                case "REMOVE:":
                    System.out.println(provinceManager.remove(commandTokens));
                    System.out.println("---");
                    break;
                case "FIGHT:":
                    System.out.println(provinceManager.fight(commandTokens[1], commandTokens[2], commandTokens[3], commandTokens[4]));
                    System.out.println("---");
                    break;
            }
        }
        System.out.println(provinceManager.end());
    }
}
