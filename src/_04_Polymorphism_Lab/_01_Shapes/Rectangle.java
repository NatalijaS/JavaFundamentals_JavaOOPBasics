package _04_Polymorphism_Lab._01_Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.setHeight(height);
        this.setWidth(width);
        this.calculatePerimeter();
        this.calculateArea();
    }


    @Override
    public void calculatePerimeter() {
        super.setPerimeter(this.getHeight() * 2 + this.getWidth() * 2);
    }

    @Override
    public void calculateArea() {
        super.setArea(this.getHeight() * this.getWidth());
    }

    private Double getHeight() {
        return height;
    }

    private Double getWidth() {
        return width;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private void setWidth(Double width) {
        this.width = width;
    }
}
