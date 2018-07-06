package _02_Encapsulation_Lab._04_firstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String nam;
    private List<Person> firstTeamPlayers;
    private List<Person> reserveTeamPlayers;

    public Team(String nam) {
        this.nam = nam;
        this.firstTeamPlayers = new ArrayList<>();
        this.reserveTeamPlayers = new ArrayList<>();
    }

    public List<Person> getFirstTeamPlayers() {
        return Collections.unmodifiableList(firstTeamPlayers);
    }

    public List<Person> getReserveTeamPlayers() {
        return Collections.unmodifiableList(reserveTeamPlayers);
    }

    public void addPlayer(Person person) {
        if (person.getAge() < 40) {
            this.firstTeamPlayers.add(person);
        } else {
            this.reserveTeamPlayers.add(person);
        }
    }

}

