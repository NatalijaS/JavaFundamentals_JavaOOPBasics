package exams._2018_07_08_TheWarOfTheComic;

import exams._2018_07_08_TheWarOfTheComic.contracts.SuperPower;

public class Power implements SuperPower {

    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    public void setName(String name) {
        if(!name.matches("@[a-zA-Z_]+@") || name.length() < 5){
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }
        this.name = name;
    }

    private void setPowerPoints(double powerPoints) {
        if(powerPoints < 0.0){
            throw new IllegalArgumentException("Power points should be a possitive number!");
        }
        this.powerPoints = powerPoints;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPowerPoints() {
        return this.powerPoints + this.name.length() / 2;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
