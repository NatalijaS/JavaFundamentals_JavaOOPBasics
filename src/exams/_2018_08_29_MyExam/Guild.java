package exams._2018_08_29_MyExam;

import characters.Characters;
import interfaces.Hero;

import java.text.DecimalFormat;
import java.util.*;

public class Guild {

    private String name;
    private Map<String, Hero> heroes;

    public Guild(String name) {
        this.name = name;
        this.heroes = new LinkedHashMap<>();
    }

    public Map<String, Hero> getHeroes() {
        return heroes;
    }

    public String getName() {
        return name;
    }

    public String addHero(Hero hero) {
        if (!this.heroes.containsKey(hero.getName())) {
            this.heroes.put(hero.getName(), hero);
            return String.format("Added hero: %s", hero.getName());
        } else {
            if (hero.getTotalPoints() > this.heroes.get(hero.getName()).getTotalPoints()) {
                this.heroes.put(hero.getName(), hero);//todo: not sure if its right
                return String.format("Updated hero: %s", hero.getName());
            } else {
                return String.format("Hero %s can not be replaced by a weaker one.", hero.getName());
            }
        }
    }

    public String removeHero(Hero hero) {
        this.heroes.remove(hero.getName());
        return String.format("Successfully removed hero [%s] from guild %s", hero.getName(), this.getName());
    }

    public Characters getHeroByName(String heroName) {
        return (Characters) this.heroes.get(heroName);
    }

    public Long getGuildSize() {
        return (long) this.heroes.values().size();
    }

    public double getGuildPower() {
        double sum = 0.0;
        for (Hero hero : heroes.values()) {
            sum += hero.getTotalPoints();
        }

        DecimalFormat df = new DecimalFormat("#.00");//todo
        return Double.parseDouble(df.format(sum));
    }

    public String getGuildSpecialization() { //todo
        int willpowerCount = 0;
        int sumWillpower = 0;
        int strengthCount = 0;
        int sumStrength = 0;
        int enduranceCount = 0;
        int sumEndurance = 0;

        for (Hero hero : heroes.values()) {
            switch (hero.getClass().getSuperclass().getSimpleName()) {
                case "Willpower":
                    willpowerCount++;
                    sumWillpower += hero.getTotalPoints();
                    break;
                case "Strength":
                    strengthCount++;
                    sumStrength += hero.getTotalPoints();
                    break;
                case "Endurance":
                    enduranceCount++;
                    sumEndurance += hero.getTotalPoints();
                    break;
            }
        }

        if (willpowerCount > strengthCount && willpowerCount > enduranceCount) {
            return "Willpower";
        } else if (strengthCount > willpowerCount && strengthCount > enduranceCount) {
            return "Strength";
        } else if (enduranceCount > willpowerCount && enduranceCount > strengthCount) {
            return "Endurance";
        } else {
            if (sumWillpower > sumStrength && sumWillpower > sumEndurance) {
                return "Willpower";
            } else if (sumStrength > sumWillpower && sumStrength > sumEndurance) {
                return "Strength";
            } else {
                return "Endurance";
            }
        }
    }

    @Override
    public String toString() {
        //##Guild: Name: {guild1name}, Power: {guild1power}, Size: {guild1size}
        return String.format("##Guild: Name: %s, Power: %.2f, Size: %d"
                , this.getName(), this.getGuildPower(), this.getGuildSize());
    }
}
