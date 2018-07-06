package _02_Encapsulation_Lab._04_firstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            Person person = new Person(tokens[0], tokens[1], Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
            persons.add(person);
        }
        Team team = new Team("Minior");
        for (Person person : persons) {
            team.addPlayer(person);
        }
        System.out.println("First team have " + team.getFirstTeamPlayers().size() + " players");
        System.out.println("Reserve team have " + team.getReserveTeamPlayers().size() + " players");
    }
}
