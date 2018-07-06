package exams.exam_12_Nov_2017.cells.microbes;

public class Virus extends Microbe {
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return this.getHealth() + this.getVirulence();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
