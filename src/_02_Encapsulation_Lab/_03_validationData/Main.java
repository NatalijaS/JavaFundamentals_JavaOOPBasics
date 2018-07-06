package _02_Encapsulation_Lab._03_validationData;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] tokens = reader.readLine().split(" ");
            Person person = new Person();
            try {
                person.setFirstName(tokens[0]);
                person.setLastName(tokens[1]);
                person.setAge(Integer.parseInt(tokens[2]));
                person.setSalary(Double.parseDouble(tokens[3]));
                persons.add(person);
            }catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
        int bonus = Integer.parseInt(reader.readLine());
        for (Person person : persons) {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        }
    }
}
