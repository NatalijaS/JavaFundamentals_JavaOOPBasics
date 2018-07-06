package _02_Encapsulation_Exercises._01_classBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        this.length = length;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    public double getSurfaceArea(){
        return (2.0 * this.length * this.width) + (2.0 * this.length * this.height) + (2.0 * this.width * this.height);
    }
    public double getLateralSurfaceArea(){
        return (2.0 * this.length * this.height) + (2.0 * this.width * this.height);
    }
    public double getVolume(){
        return this.length * this.width * this.height;
    }

}
