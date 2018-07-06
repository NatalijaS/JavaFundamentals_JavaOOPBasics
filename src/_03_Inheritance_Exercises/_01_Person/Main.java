package _03_Inheritance_Exercises._01_Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        Integer age = Integer.parseInt(reader.readLine());

        try {
            Child child = new Child(name, age);
            System.out.println(child);
            String personClassName = Person.class.getSimpleName();
            String childClassName = Child.class.getSimpleName();
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
