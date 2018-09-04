package exams._2016_10_07_SystemSplit.models;

public abstract class Component {

    private String name;
    private String type;
    private int capacity;
    private int memory;

    protected Component(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMemory() {
        return memory;
    }

    protected void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    protected void setMemory(int memory) {
        this.memory = memory;
    }
}
