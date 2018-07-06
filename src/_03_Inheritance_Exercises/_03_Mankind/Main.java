package _03_Inheritance_Exercises._03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = reader.readLine().split(" ");
        String[] line2 = reader.readLine().split(" ");

        try {
            Student student = new Student(line1[0], line1[1], line1[2]);
            System.out.println(student);
            Worker worker = new Worker(line2[0], line2[1], Double.parseDouble(line2[2]), Double.parseDouble(line2[3]));
            System.out.println(worker);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
