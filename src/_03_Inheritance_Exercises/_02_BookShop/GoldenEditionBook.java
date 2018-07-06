package _03_Inheritance_Exercises._02_BookShop;

public class GoldenEditionBook extends Book {

    public GoldenEditionBook( String author, String title, double price) {
        super(author, title,  price);
    }

    @Override
    protected void setPrice(double price) {
        super.setPrice(price + 0.3 * price);
    }
}
