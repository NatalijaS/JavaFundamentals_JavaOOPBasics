package exams._2018_07_08_TheWarOfTheComic;

import exams._2018_07_08_TheWarOfTheComic.contracts.Arena;
import exams._2018_07_08_TheWarOfTheComic.contracts.ComicCharacter;
import exams._2018_07_08_TheWarOfTheComic.contracts.Manager;
import exams._2018_07_08_TheWarOfTheComic.contracts.SuperPower;
import exams._2018_07_08_TheWarOfTheComic.models.antiheroes.Titan;
import exams._2018_07_08_TheWarOfTheComic.models.antiheroes.Villain;
import exams._2018_07_08_TheWarOfTheComic.models.heroes.DCHero;
import exams._2018_07_08_TheWarOfTheComic.models.heroes.MarvelHero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Manager manager = new WarManager();

        String line;
        while (!"WAR_IS_OVER".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ");
            try {
                switch (tokens[0]) {
                    case "CHECK_CHARACTER":
                        System.out.println(manager.checkComicCharacter(tokens[1]));
                        break;
                    case "REGISTER_HERO":
                        switch (tokens[2]) {
                            case "DCHero":
                                ComicCharacter dcHero = new DCHero(tokens[1], Integer.parseInt(tokens[3])
                                        , Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5])
                                        , Double.parseDouble(tokens[6]));
                                System.out.println(manager.addHero(dcHero));
                                break;
                            case "MarvelHero":
                                ComicCharacter marvelHero = new MarvelHero(tokens[1], Integer.parseInt(tokens[3])
                                        , Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5])
                                        , Double.parseDouble(tokens[6]));
                                System.out.println(manager.addHero(marvelHero));
                                break;
                        }
                        break;
                    case "REGISTER_ANTI_HERO":
                        switch (tokens[2]) {
                            case "Titan":
                                ComicCharacter titan = new Titan(tokens[1], Integer.parseInt(tokens[3])
                                        , Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5])
                                        , Double.parseDouble(tokens[6]));
                                System.out.println(manager.addAntiHero(titan));
                                break;
                            case "Villain":
                                ComicCharacter villain = new Villain(tokens[1], Integer.parseInt(tokens[3])
                                        , Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5])
                                        , Double.parseDouble(tokens[6]));
                                System.out.println(manager.addAntiHero(villain));
                                break;
                        }
                        break;
                    case "BUILD_ARENA":
                        String name = tokens[1];
                        int capacity = Integer.parseInt(tokens[2]);
                        Arena arena = new ArenaImpl(name, capacity);

                        System.out.println(manager.addArena(arena));
                        break;
                    case "SEND_HERO":
                        String arenaName = tokens[1];
                        String heroName = tokens[2];

                        System.out.println(manager.addHeroToArena(arenaName, heroName));
                        break;
                    case "SEND_ANTI_HERO":
                        String arenaName2 = tokens[1];
                        String heroName2 = tokens[2];

                        System.out.println(manager.addAntiHeroToArena(arenaName2, heroName2));
                        break;
                    case "SUPER_POWER":
                        String powerName = tokens[1];
                        double points = Double.parseDouble(tokens[2]);
                        SuperPower superPower = new Power(powerName, points);

                        System.out.println(manager.loadSuperPowerToPool(superPower));
                        break;
                    case "ASSIGN_POWER":
                        String characterName = tokens[1];
                        String superPowerName = tokens[2];

                        System.out.println(manager.assignSuperPowerToComicCharacter(characterName, superPowerName));
                        break;
                    case "UNLEASH":
                        String chName = tokens[1];

                        System.out.println(manager.usePowers(chName));
                        break;
                    case "COMICS_WAR":
                        String arenaName1 = tokens[1];

                        System.out.println(manager.startBattle(arenaName1));
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(manager.endWar());
    }
}
