package exams._2018_08_29_MyExam;

import characters.*;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProvinceManager {

    private Map<String, Province> provinceMap;
    private Province selectedProvince;

    public ProvinceManager() {
        this.provinceMap = new LinkedHashMap<>();

    }

    public String createProvince(String provinceName){
        if(this.provinceMap.containsKey(provinceName)){
            return String.format("Province with name %s already exists!", provinceName);
        }else{
            this.provinceMap.put(provinceName, new Province(provinceName));
            this.selectedProvince = this.provinceMap.get(provinceName);
            return String.format("Created province %s", provinceName);
        }
    }

    public String selectProvince(String provinceName){
        if(!this.provinceMap.containsKey(provinceName)){
            return String.format("Province %s does not exist", provinceName);
        }
        if(this.selectedProvince.getName().equals(provinceName)){
            return String.format("Province %s has already been selected!", provinceName);
        }

        this.selectedProvince = this.provinceMap.get(provinceName);
        return String.format("Province %s selected!", provinceName);
    }

    public String addHero(String guildName, String heroType, String heroName,  int health, int fatigue, int magicka){
        if(this.selectedProvince == null){
            return "No province selected!";
        }

        if(!this.selectedProvince.contains(guildName)){
            this.selectedProvince.addGuild(new Guild(guildName));
        }

        if(!heroType.equals("Breton") && !heroType.equals("Dunmer") && !heroType.equals("Khajiit") && !heroType.equals("Nord")
                && !heroType.equals("Orc") && !heroType.equals("Redguard")){
            return "No such hero type!";
        }

        if(health < 1 && fatigue < 1 && magicka < 1){
            return "Invalid character stats!";
        }

        switch (heroType){
            case "Breton":
                return this.selectedProvince.getGuildByName(guildName)
                        .addHero(new Breton(heroName, magicka, fatigue, health));
            case "Dunmer":
                return this.selectedProvince.getGuildByName(guildName)
                        .addHero(new Dunmer(heroName, magicka, fatigue, health));
            case "Khajiit":
                return this.selectedProvince.getGuildByName(guildName)
                        .addHero(new Khajiit(heroName, magicka, fatigue, health));
            case "Nord":
                return this.selectedProvince.getGuildByName(guildName)
                        .addHero(new Nord(heroName, magicka, fatigue, health));
            case "Orc":
                return this.selectedProvince.getGuildByName(guildName)
                        .addHero(new Orc(heroName, magicka, fatigue, health));
            default:
                return this.selectedProvince.getGuildByName(guildName)
                        .addHero(new Redguard(heroName, magicka, fatigue, health));
        }
    }

    public String addGuild(String guildName){
        if(this.selectedProvince == null){
            return "No province selected!";
        }

        if(this.selectedProvince.contains(guildName)){
            return "Guild already exists.";
        }

        return (this.selectedProvince.addGuild(new Guild(guildName)));
    }

    public String details(String... args){
        if(this.selectedProvince == null){
            return "No province selected!";
        }
        String guildName = args[1];
        if(!this.selectedProvince.contains(guildName)){
            return String.format("Guild [%s] does not exist.", guildName);
        }

        if(args.length == 2){
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Guild: %s", guildName)).append(System.lineSeparator());
            sb.append("###Heroes: ");

            if(this.selectedProvince.getGuildByName(guildName).getHeroes().values().size() == 0){
                return sb.toString() + "None";
            }else{
                sb.append(System.lineSeparator());
            }
            this.selectedProvince.getGuildByName(guildName).getHeroes().values().stream()
                    .sorted((h1, h2)->{
                        int compare = Double.compare(h1.getTotalPoints(), h2.getTotalPoints());
                        int count = 0;
                        if(compare == 0 && count < 2){
                            count++;
                        }
                        if(count >= 2){
                            compare = h1.getName().compareTo(h2.getName());
                        }
                        return compare;
                    })
                    .forEach(h -> sb.append(h.toString()).append(System.lineSeparator()));

            return sb.toString();

        }else{
            String heroName = args[2];
            if(!this.selectedProvince.getGuildByName(guildName).getHeroes().containsKey(heroName)){
                return "No such hero in this guild!";
            }

            StringBuilder sb = new StringBuilder();

            sb.append(String.format("Hero: %s, Type: [%s]", heroName,
                    this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName).getHeroType()))
                    .append(System.lineSeparator())
                    .append("#Stats: ").append(String.format("%n"))
                    .append(String.format("Health: %d",
                            this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName).getHealth()))
                    .append(System.lineSeparator())
                    .append(String.format("Fatigue: %d",
                            this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName).getFatigue()))
                    .append(System.lineSeparator())
                    .append(String.format("Magicka: %d",
                            this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName).getMagicka()));

            if(this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName).getClass().getSuperclass().getSimpleName()
                    .equals("Endurance")){
                sb.append(System.lineSeparator());
                sb.append("#Endurance bonuses:").append(System.lineSeparator())
                        .append(String.format("Magic resistance: +%.1f defense.",
                                this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName).getSpecial()));
            }

            if(this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName).getClass().getSuperclass().getSimpleName()
                    .equals("Strength")){
                sb.append(System.lineSeparator());
                sb.append("#Strength bonuses:").append(System.lineSeparator())
                        .append(String.format("Magic damage: +%.1f offense.",
                                this.selectedProvince.getGuildByName(guildName).getHeroByName(heroName).getSpecial()));
            }
            return sb.toString();
        }
    }

    public String remove(String... args) {
        if (this.selectedProvince == null) {
            return "No province selected!";
        }

        String guildName = args[1];
        if(!this.selectedProvince.contains(guildName)){
            return String.format("Guild [%s] does not exist.", guildName);
        }

        if(args.length == 2){
            this.selectedProvince.removeGuild(this.selectedProvince.getGuildByName(guildName));
            return String.format("Removed guild %s with %d members.", guildName,
                    this.selectedProvince.getGuildByName(guildName).getHeroes().values().size());
        }else{
            String heroName = args[2];
            if(!this.selectedProvince.getGuildByName(guildName).getHeroes().containsKey(heroName)){
                return "No such hero in this guild!";
            }

            this.selectedProvince.getGuildByName(guildName)
                    .removeHero(this.selectedProvince.getGuildByName(guildName).getHeroes().get(heroName));

            return String.format("Successfully removed hero [%s] from guild %s",  heroName, guildName);
        }
    }

    public String fight(String guild1Name, String hero1Name,  String guild2Name,  String hero2Name){
        if (this.selectedProvince == null) {
            return "No province selected!";
        }

        Guild guild1 = this.selectedProvince.getGuildByName(guild1Name);
        Characters hero1 = guild1.getHeroByName(hero1Name);
        Guild guild2 = this.selectedProvince.getGuildByName(guild2Name);
        Characters hero2 = guild2.getHeroByName(hero2Name);

        if(guild1.getName().equals(guild2.getName())){
            return "Heroes from the same guild can not fight each other.";
        }

        if(hero1 == null || hero2 == null){
            return "No such hero in this guild!";
        }

        while(!hero1.isDead() &&  !hero2.isDead()){
            if(hero1.getHealth() > hero2.getHealth()){
               hero1.attack(hero2);
            }else if(hero2.getHealth() > hero1.getHealth()){
                hero2.attack(hero1);
            }else if(hero1.getOffense() > hero2.getOffense()){
                hero1.attack(hero2);
            }else{
                hero2.attack(hero1);
            }
        }

        if(hero1.getHealth() < 1){
            guild1.removeHero(hero1);
            return String.format("Hero %s sliced hero %s."
                    , hero2.getName(), hero1.getName());
        }else{
            guild2.removeHero(hero2);
            return String.format("Hero %s sliced hero %s."
                    , hero1.getName(), hero2.getName());
        }

    }

    public String end(){
        StringBuilder sb = new StringBuilder();

        this.provinceMap.values().stream().sorted(Comparator.comparing(p -> p.getName()))
                .forEach(p -> {
                    sb.append(String.format("Province: %s", p.getName())).append(System.lineSeparator())
                            .append("#Guilds: ");
                    if(p.getGuilds().values().size() == 0){
                        sb.append("None").append(System.lineSeparator());
                    }else{
                        sb.append(String.format("%n"));
                        p.getGuilds().values().stream().sorted((g1, g2) -> {
                            int compare = Double.compare(g2.getGuildPower(), g1.getGuildPower());
                            if(compare == 0){
                                compare = g1.getName().compareTo(g2.getName());
                            }
                            return compare;
                        }).forEach(g -> sb.append(g.toString()).append(System.lineSeparator()));
                    }
                });
        return sb.toString();
    }
}
