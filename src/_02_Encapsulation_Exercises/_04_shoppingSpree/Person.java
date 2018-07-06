package _02_Encapsulation_Exercises._04_shoppingSpree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private int money;
    private List<Product> productList;

    public Person(String name, int money) {
        this.setName(name);
        this.setMoney(money);
        this.productList = new ArrayList<>();

    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }
    private void addProduct(Product product) {
        this.productList.add(product);
    }

    private List<Product> getProductList() {
        return Collections.unmodifiableList(this.productList);
    }

    String byProduct(Product product) {
        if (this.money - product.getCost() < 0) {
            return this.name + " can't afford " + product.getName();
        } else {
            addProduct(product);
            this.setMoney(this.money - product.getCost());
            return this.name + " bought " + product.getName();
        }
    }

    @Override
    public String toString() {
        if (this.productList.isEmpty()) {
            return this.name + " - Nothing bought";
        }
        return this.name + " - " + String.join(", ",
                this.getProductList().stream().map(Object::toString).collect(Collectors.toList()));
    }
}
