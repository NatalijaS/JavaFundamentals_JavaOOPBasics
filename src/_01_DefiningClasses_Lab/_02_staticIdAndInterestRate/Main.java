package _01_DefiningClasses_Lab._02_staticIdAndInterestRate;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static int id = 0;

    public static void main(String[] args) {
        Map<Integer, BankAccount> accounts = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        String line;
        while (!"End".equalsIgnoreCase(line = scanner.nextLine())) {
            String[] commandArgs = line.split("\\s+");
            String commandType = commandArgs[0];
            switch (commandType) {
                case "Create":
                    execCreate(commandArgs, accounts);
                    break;
                case "Deposit":
                    execDeposit(commandArgs, accounts);
                    break;
                case "SetInterest":
                    execSetInterest(commandArgs, accounts);
                    break;
                case "GetInterest":
                    execGetInterest(commandArgs, accounts);
                    break;
            }
        }
    }

    private static void execGetInterest(String[] commandArgs, Map<Integer, BankAccount> accounts) {
        int targetId = Integer.valueOf(commandArgs[1]);
        if (accounts.containsKey(targetId)) {
            int years = Integer.parseInt(commandArgs[2]);
            BankAccount account = accounts.get(targetId);
            double interest = account.getInterest(years);
            System.out.printf("%.2f%n", interest);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void execSetInterest(String[] commandArgs, Map<Integer, BankAccount> accounts) {
        BankAccount.setInterest(Double.valueOf(commandArgs[1]));
    }

    private static void execDeposit(String[] commandArgs, Map<Integer, BankAccount> accounts) {
        int targetId = Integer.valueOf(commandArgs[1]);
        if (accounts.containsKey(targetId)) {
            double depositAmount = Double.parseDouble(commandArgs[2]);
            BankAccount account = accounts.get(targetId);
            account.deposit(depositAmount);
            System.out.printf("Deposited %.0f to %s%n", depositAmount, account);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void execCreate(String[] commandArgs, Map<Integer, BankAccount> accounts) {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.printf("Account %s created%n", account);
    }
}
