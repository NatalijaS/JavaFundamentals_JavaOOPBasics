package _02_Encapsulation_Exercises._06_footballTeamGenerator;

import java.util.Map;

public class Player {
    private String name;
    private Map<String, Double> stats;

    public Player(String name, Map<String, Double> stats) {
        this.name = name;
        this.stats = stats;
    }

    double getAverageStats() {
        return stats.values().stream().reduce(0.0, (a, b) -> a + b) / stats.size();
    }
}
