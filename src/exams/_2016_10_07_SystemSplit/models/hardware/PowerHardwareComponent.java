package exams._2016_10_07_SystemSplit.models.hardware;

public class PowerHardwareComponent extends HardwareComponent {

    private static final String TYPE = "exams._2018_07_08_TheWarOfTheComic.Power";

    public PowerHardwareComponent(String name, int capacity, int memory) {
        super(name, TYPE);
        this.calculateCapacity(capacity);
        this.calculateMemory(memory);
    }


    @Override
    protected void calculateMemory(int memory) {
        super.setMemory(memory + ((int)(0.75 * memory)));
    }

    @Override
    protected void calculateCapacity(int capacity) {
        super.setCapacity(capacity - ((int)(0.75 * capacity)));
    }
}
