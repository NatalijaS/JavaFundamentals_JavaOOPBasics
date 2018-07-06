package _03_Inheritance_Lab._06_stackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;


    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String element) {
        this.data.add(element);
    }

    public String pop() {
        String element = this.data.get(this.data.size() - 1);
        this.data.remove(this.data.size() - 1);
        return element;
    }

    public String peek() {
        return this.data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return this.data.size() == 0;
    }
}
