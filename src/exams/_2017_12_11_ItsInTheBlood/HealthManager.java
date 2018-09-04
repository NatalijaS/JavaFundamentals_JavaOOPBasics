package exams._2017_12_11_ItsInTheBlood;

import exams._2017_12_11_ItsInTheBlood.cells.Cell;
import exams._2017_12_11_ItsInTheBlood.cells.bloodCells.BloodCell;
import exams._2017_12_11_ItsInTheBlood.cells.bloodCells.RedBloodCell;
import exams._2017_12_11_ItsInTheBlood.cells.bloodCells.WhiteBloodCell;
import exams._2017_12_11_ItsInTheBlood.cells.microbes.Bacteria;
import exams._2017_12_11_ItsInTheBlood.cells.microbes.Fungi;
import exams._2017_12_11_ItsInTheBlood.cells.microbes.Virus;
import exams._2017_12_11_ItsInTheBlood.cluster.Cluster;

import java.util.*;
import java.util.stream.Collectors;

public class HealthManager {

    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public String createOrganism(String name) {
        if (!organisms.containsKey(name)) {
            organisms.put(name, new Organism(name));
            return String.format("Created organism %s", name);
        } else {
            return String.format("Organism %s already exists", name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        Cluster cluster = new Cluster(id, rows, cols);

        if (this.organisms.containsKey(organismName) && !organisms.get(organismName).getClusters().containsValue(cluster)) {
            organisms.get(organismName).addCluster(cluster);
            return String.format("Organism %s: Created cluster %s", organismName, id);
        }
        return "";
    }

    public String addCell(String organismName, String clusterId, String cellType,
                          String cellId, int health, int positionRow, int positionCol, int additionalProperty) {

        if (!this.organisms.containsKey(organismName) || !this.organisms.get(organismName).getClusters().containsKey(clusterId)) {
            return "";
        } else {
            int clusterRow = this.organisms.get(organismName).getClusters().get(clusterId).getRows();
            int clusterCol = this.organisms.get(organismName).getClusters().get(clusterId).getCols();
            if ((positionRow > clusterRow - 1 || positionRow < 0) || (positionCol > clusterCol - 1 || positionCol < 0)) {
                return "";
            }
        }

        Cell cell;
        switch (cellType) {
            case "WhiteBloodCell":
                cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "RedBloodCell":
                cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Bacteria":
                cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            case "Fungi":
                cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                break;
            default:
                cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                break;
        }
        organisms.get(organismName).addCell(cell, clusterId);

        return String.format("Organism %s: Created cell %s in cluster %s"
                , organismName, cellId, clusterId);
    }

    public String checkCondition(String organismName) {

        if (this.organisms.containsKey(organismName)) {
            return String.format("Organism - %s\n", organismName) +
                    String.format("--Clusters: %d\n", organisms.get(organismName).getClustersCount()) +
                    String.format("--Cells: %d\n", organisms.get(organismName).getCellsCount()) +
                    getClusterInfo(organismName);
        }
        return "";
    }

    private String getClusterInfo(String organismName) {

        StringBuilder sb = new StringBuilder();
        organisms.get(organismName).getClusters().values().forEach(c -> {
            sb.append(c.toString()).append("\n");
            c.getCells().stream().sorted(Comparator.comparingInt(Cell::getPositionRow)
                    .thenComparing(Comparator.comparingInt(Cell::getPositionCol)))
                    .forEach(l -> {
                        sb.append(String.format("------Cell %s [%d,%d]\n", l.getId(), l.getPositionRow(), l.getPositionCol()));
                        sb.append(l.toString()).append("\n");
                    });
        });

        return sb.toString();
    }


    public String activateCluster(String organismName) {

        if (!this.organisms.containsKey(organismName) || this.organisms.get(organismName).getClusters().size() < 1) {
            return "";
        }
        String clusterName = "";
        try {
            for (Cluster cluster : this.organisms.get(organismName).getClusters().values()) {
                clusterName = cluster.getId();
                Comparator<Cell> byRow = Comparator.comparing(Cell::getPositionRow);
                Comparator<Cell> byCol = Comparator.comparing(Cell::getPositionCol);
                List<Cell> sorted = cluster.getCells().stream().sorted(byRow.thenComparing(byCol)).collect(Collectors.toList());

                for (int i = 1; i < sorted.size(); i++) {
                    if (sorted.get(0) instanceof BloodCell) {
                        sorted.get(0).setHealth(sorted.get(0).getHealth() + sorted.get(i).getHealth());
                        sorted.get(0).setPositionRow(sorted.get(i).getPositionRow());
                        sorted.get(0).setPositionCol(sorted.get(i).getPositionCol());
                    } else {
                        while (true) {
                            sorted.get(i).setHealth(sorted.get(i).getHealth() - sorted.get(0).getEnergy());
                            if (sorted.get(i).getHealth() <= 0) {
                                sorted.get(0).setPositionRow(sorted.get(i).getPositionRow());
                                sorted.get(0).setPositionCol(sorted.get(i).getPositionCol());
                                break;
                            }
                            sorted.get(0).setHealth(sorted.get(0).getHealth() - sorted.get(i).getEnergy());
                            if (sorted.get(0).getHealth() <= 0) {
                                sorted.set(0, sorted.get(i));
                                break;
                            }
                        }
                    }
                }

                cluster.getCells().clear();
                cluster.addCell(sorted.get(0));
                break;
            }
        } catch (Exception ignored) {
        }

        Cluster cluster = this.organisms.get(organismName).getClusters().get(clusterName);
        this.organisms.get(organismName).getClusters().remove(clusterName);
        this.organisms.get(organismName).getClusters().putIfAbsent(clusterName, cluster);
        int size = cluster.getCells().size();

        return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, cluster.getId(), size);
    }

}
