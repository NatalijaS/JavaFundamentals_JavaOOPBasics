package exams._2017_12_11_ItsInTheBlood.cluster;


import exams._2017_12_11_ItsInTheBlood.cells.Cell;

import java.util.ArrayList;
import java.util.List;

public class Cluster {

    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.setId(id);
        this.setRows(rows);
        this.setCols(cols);
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getRows() {
        return rows;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    private void setCols(int cols) {
        this.cols = cols;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public List<Cell> getCells() {
        return this.cells;
    }

    private void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        return String.format("----Cluster %s", this.getId());
    }
}
