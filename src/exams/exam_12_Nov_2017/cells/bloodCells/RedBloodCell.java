package exams.exam_12_Nov_2017.cells.bloodCells;


public class RedBloodCell extends BloodCell {
    private int velocity;

    public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
        super(id, health, positionRow, positionCol);
        this.setVelocity(velocity);
    }


    public int getVelocity() {
        return velocity;
    }

    private void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    @Override
    public int getEnergy() {
        return this.getHealth() + this.velocity;
    }

    @Override
    public String toString() {
        return String.format("--------Health: %d | Velocity: %d | Energy: %d"
                , this.getHealth(), this.getVelocity(), this.getEnergy());
    }
}
