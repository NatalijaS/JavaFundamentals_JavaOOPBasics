package _01_DefiningClasses_Exercises._03_opinionPoll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> people = new LinkedHashSet<>();
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String [] line = reader.readLine().split("\\s+");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            Person persona = new Person(name, age);
            people.add(persona);
        }
        people.stream().filter(p -> p.getAge() >30).sorted().forEach(p1 -> System.out.println(p1.getName() + " - " + p1.getAge()));
    }
}
