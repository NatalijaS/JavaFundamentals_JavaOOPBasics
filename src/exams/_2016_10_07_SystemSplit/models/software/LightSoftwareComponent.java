package exams._2016_10_07_SystemSplit.models.software;

public class LightSoftwareComponent extends SoftwareComponent {

    private static final String TYPE = "Light";

    public LightSoftwareComponent(String name, int capacity, int memory) {
        super(name, TYPE);
        this.setCapacity(capacity);
        this.setMemory(memory);
    }

    @Override
    protected void setCapacity(int capacity) {
        super.setCapacity(capacity + ((int)(0.50 * capacity)));
    }

    @Override
    protected void setMemory(int memory) {
        super.setMemory(memory - ((int)(0.50 * memory)));
    }
}
