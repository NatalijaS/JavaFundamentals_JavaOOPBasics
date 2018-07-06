package _02_Encapsulation_Exercises._04_shoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Person> people = new LinkedHashMap<>();
        String[] line1 = reader.readLine().split(";");
        for (int i = 0; i < line1.length ; i ++) {
            String [] personTokens = line1[i].split("=");
            String personName = personTokens[0];
            int personMoney = Integer.parseInt(personTokens[1]);
            Person person;
            try{
                person = new Person(personName, personMoney);
                people.put(personName, person);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        Map<String, Product> products = new LinkedHashMap<>();
        String[] line2 = reader.readLine().split(";");
        for (int i = 0; i < line2.length ; i ++) {
            String [] productTokens = line2[i].split("=");
            String productName = productTokens[0];
            int productCost = Integer.parseInt(productTokens[1]);
            Product product;
            try{
                product = new Product(productName, productCost);
                products.put(productName, product);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
                return;
            }
        }

        String line3 = reader.readLine();
        while(!"END".equals(line3)){
            String [] tokens = line3.split("\\s+");
            String personName= tokens[0];
            String productName = tokens[1];
            System.out.println(people.get(personName).byProduct(products.get(productName)));
            line3 = reader.readLine();
        }

        people.values().forEach(System.out::println);
    }
}
