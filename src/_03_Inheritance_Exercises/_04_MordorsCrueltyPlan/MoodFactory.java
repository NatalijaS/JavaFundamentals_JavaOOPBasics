package _03_Inheritance_Exercises._04_MordorsCrueltyPlan;

public class MoodFactory extends FoodFactory {
    private String mood;

    String getMood() {
        return mood;
    }

    void setMood() {
        if (this.getPoints() < -5) {
            this.mood = "Angry";
        } else if (this.getPoints() < 0) {
            this.mood = "Sad";
        } else if (this.getPoints() <= 15) {
            this.mood = "Happy";
        } else {
            this.mood = "JavaScript";
        }
    }
}
