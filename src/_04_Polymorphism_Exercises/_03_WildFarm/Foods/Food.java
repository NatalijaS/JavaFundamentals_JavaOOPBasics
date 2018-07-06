package _04_Polymorphism_Exercises._03_WildFarm.Foods;

public abstract class Food {
    private int _quantity;

    Food(int quantity) {
        this.setQuantity(quantity);
    }

    public int getQuantity() {
        return this._quantity;
    }

    public void setQuantity(int _quantity) {
        this._quantity = _quantity;
    }
}
