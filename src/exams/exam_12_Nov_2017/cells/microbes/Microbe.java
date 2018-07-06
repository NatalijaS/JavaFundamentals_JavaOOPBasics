package exams.exam_12_Nov_2017.cells.microbes;

import exams.exam_12_Nov_2017.cells.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.setVirulence(virulence);
    }

    public int getVirulence() {
        return virulence;
    }

    private void setVirulence(int virulence) {
        this.virulence = virulence;
    }

    @Override
    public String toString() {
        return String.format("--------Health: %d | Virulence: %d | Energy: %d"
                , this.getHealth(), this.getVirulence(), this.getEnergy());
    }
}
