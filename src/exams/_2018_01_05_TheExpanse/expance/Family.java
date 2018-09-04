package exams._2018_01_05_TheExpanse.expance;

import exams._2018_01_05_TheExpanse.expance.colonists.Colonist;

import java.util.*;

public class Family {

    private String id;
    private Map<String, Colonist> colonists;

    public Family(String id) {
        this.id = id;
        this.colonists = new LinkedHashMap<>();
    }

    public String getId() {
        return id;
    }

    public List<Colonist> getColonists(){
        return Collections.unmodifiableList(new ArrayList<>(this.colonists.values()));
    }

    public void addColonist(Colonist colonist){
        this.colonists.put(colonist.getId(), colonist);
    }

    public void removeColonist(String colonistId){
        this.colonists.remove(colonistId);
    }

    public int getPotentialsSum(){
        return this.colonists.values().stream().mapToInt(Colonist::getPotential).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.id).append(":").append(System.lineSeparator());
        this.colonists.values().stream()
                .sorted(Comparator.comparing(Colonist::getId))
                .forEach(c -> sb.append("-").append(c).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
