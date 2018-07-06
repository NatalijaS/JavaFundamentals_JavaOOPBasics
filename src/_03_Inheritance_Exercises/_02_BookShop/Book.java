package _03_Inheritance_Exercises._02_BookShop;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        if (title.length() <= 3) {
            throw new IllegalArgumentException("Title not valid!");
        }
        this.title = title;
    }

    private String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        String[] authorTokens = author.split(" ");
        if (authorTokens.length > 1 && Character.isDigit(authorTokens[1].charAt(0))) {
            throw new IllegalArgumentException("Author not valid!");
        }
        this.author = author;
    }

    private double getPrice() {
        return price;
    }

    protected void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Price not valid!");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Type: " + this.getClass().getSimpleName() +
                System.lineSeparator() +
                "Title: " + this.getTitle() +
                System.lineSeparator() +
                "Author: " + this.getAuthor() +
                System.lineSeparator() +
                "Price: " + this.getPrice() +
                System.lineSeparator();
    }
}
