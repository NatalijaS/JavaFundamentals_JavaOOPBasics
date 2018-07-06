package exams.exam_12_Nov_2017.cells.bloodCells;

public class WhiteBloodCell extends BloodCell{
    private int size;

    public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
        super(id, health, positionRow, positionCol);
        this.setSize(size);
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getEnergy(){
        return (this.getHealth() + this.size) * 2;
    }

    @Override
    public String toString() {
        return String.format("--------Health: %d | Size: %d | Energy: %d"
                , this.getHealth(), this.getSize(), this.getEnergy());
    }
}
