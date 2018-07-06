package _03_Inheritance_Exercises._04_MordorsCrueltyPlan;

import java.util.HashMap;
import java.util.Map;

public class FoodFactory {
    private static final Map<String, Integer> FOOD_MODIFIERS = new HashMap<String, Integer>() {{
        put("cram", 2);
        put("lembas", 3);
        put("apple", 1);
        put("melon", 1);
        put("honeycake", 5);
        put("mushrooms", -10);
    }};
    private int points;

    int getPoints() {
        return points;
    }

    void eatFood(String food) {
        if(!FOOD_MODIFIERS.containsKey(food)){
            this.points -= 1;
        }else{
            this.points += FOOD_MODIFIERS.get(food);
        }
    }
}
