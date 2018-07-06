package exams.exam_12_Nov_2017;

import exams.exam_12_Nov_2017.cells.Cell;
import exams.exam_12_Nov_2017.cluster.Cluster;

import java.util.*;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name) {
        this.setName(name);
        this.clusters = new LinkedHashMap<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Map<String, Cluster> getClusters() {
        return this.clusters;
    }
    public void addCluster(Cluster cluster){
        this.clusters.put(cluster.getId(), cluster);
    }
    public void addCell(Cell cell, String clusterId){
        this.clusters.get(clusterId).addCell(cell);
    }
    public Cluster getCluster(String id){
        return this.clusters.get(id);
    }

    public int getClustersCount(){
        return this.clusters.size();
    }
    public int getCellsCount(){
        return this.clusters.values().stream().mapToInt(c -> c.getCells().size()).sum();
    }

    @Override
    public String toString() {
        return "organism" + this.getName();
    }
}
