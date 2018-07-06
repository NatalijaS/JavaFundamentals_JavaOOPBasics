package _01_DefiningClasses_Lab._02_staticIdAndInterestRate;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Integer age;
    private List<BankAccount> accounts;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.accounts = new ArrayList<>();
    }

    public Person(String name, Integer age, List<BankAccount> accounts) {
        this.name = name;
        this.age = age;
        this.accounts = accounts;
    }

    public double getBalance(){
        return this.accounts.stream().mapToDouble(BankAccount::getBalance).sum();
    }

}
