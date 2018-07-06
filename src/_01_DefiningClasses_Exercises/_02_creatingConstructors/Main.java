package _01_DefiningClasses_Exercises._02_creatingConstructors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Class personClass = Person.class;
        Constructor emptyConstructor = personClass.getDeclaredConstructor();
        Constructor ageConstructor = personClass.getDeclaredConstructor(Integer.class);
        Constructor nameAgeConstructor = personClass.getDeclaredConstructor(String.class, Integer.class);
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());

        Person basePerson = (Person)emptyConstructor.newInstance();
        Person personWithAge = (Person) ageConstructor.newInstance(age);
        Person personFull = (Person) nameAgeConstructor.newInstance(name, age);

        System.out.printf("%s %s%n", basePerson.getName(), basePerson.getAge());
        System.out.printf("%s %s%n", personWithAge.getName(), personWithAge.getAge());
        System.out.printf("%s %s%n", personFull.getName(), personFull. getAge());
    }
}
