package exams._2018_08_29_MyExam;

import java.util.LinkedHashMap;
import java.util.Map;

public class Province {

    private String name;
    private Map<String, Guild> guilds;

    public Province(String name) {
        this.name = name;
        this.guilds = new LinkedHashMap<>();
    }

    public Map<String, Guild> getGuilds() {
        return guilds;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String addGuild(Guild guild){
        this.guilds.put(guild.getName(), guild);
        return String.format("Added Guild: %s", guild.getName());
    }

    public String removeGuild(Guild guild){
        this.guilds.remove(guild.getName());
        return String.format("Removed guild [%s] with %d members.", guild.getName(), guild.getGuildSize());
    }

    public Guild getGuildByName(String guildName){
        return this.guilds.get(guildName);
    }

    public boolean contains(String guildName){
        return this.guilds.containsKey(guildName);
    }
}
