package exams.exam_12_Nov_2017.cells.bloodCells;

import exams.exam_12_Nov_2017.cells.Cell;

public abstract class BloodCell extends Cell{
    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }
}
