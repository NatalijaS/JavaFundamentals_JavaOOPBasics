package exams.exam_05_Jan_2018;

import exams.exam_05_Jan_2018.colonists.Colonist;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Family {
    private String id;
    private Map<String, Colonist> colonists;

    public Family(String id) {
        this.setId(id);
        this.colonists = new LinkedHashMap<>();
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public List<Colonist> getColonists(){
        return this.colonists.values().stream()
                .sorted(Comparator.comparing(Colonist::getId))
                .collect(Collectors.toList());
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


}
