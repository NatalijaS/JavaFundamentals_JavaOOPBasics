package _03_Inheritance_Lab._04_fragileBaseClass;

import java.util.List;

public class Animal {
    protected List<Food> foodEaten;

    public Animal(List<Food> foodEaten) {
        this.foodEaten = foodEaten;
    }

    public final void eat(Food food){
        this.foodEaten.add(food);
    }

    public void eatAll(Food [] foods){
        for (Food food : foods) {
            this.eat(food);
        }
    }
}
