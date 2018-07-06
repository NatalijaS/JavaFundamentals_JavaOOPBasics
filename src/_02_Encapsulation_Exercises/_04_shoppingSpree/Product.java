package _02_Encapsulation_Exercises._04_shoppingSpree;

public class Product {
    private String name;
    private int cost;

    public Product(String name, int cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if(name.isEmpty() || name.charAt(0) == ' '){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(int cost) {
        if(cost < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
