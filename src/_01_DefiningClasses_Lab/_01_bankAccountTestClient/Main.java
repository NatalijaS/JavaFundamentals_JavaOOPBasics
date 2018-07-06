package _01_DefiningClasses_Lab._01_bankAccountTestClient;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, BankAccount> accounts = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!"End".equals(command)) {
            String[] commandArgs = command.split("\\s+");
            String commandType = commandArgs[0];
            switch (commandType) {
                case "Create":
                    execCreate(commandArgs, accounts);
                    break;
                case "Deposit":
                    execDeposit(commandArgs, accounts);
                    break;
                case "Withdraw":
                    execWithdraw(commandArgs, accounts);
                    break;
                case "Print":
                    execPrint(commandArgs, accounts);
                    break;
            }
            command = scanner.nextLine();
        }
    }

    private static void execPrint(String[] commandArgs, Map<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(commandArgs[1]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            System.out.println(accounts.get(id));
        }
    }

    private static void execWithdraw(String[] commandArgs, Map<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(commandArgs[1]);
        int amount = Integer.valueOf(commandArgs[2]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            if (accounts.get(id).getBalance() - amount >= 0) {
                accounts.get(id).withdraw(amount);

            } else {
                System.out.println("Insufficient balance");
            }
        }
    }

    private static void execDeposit(String[] commandArgs, Map<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(commandArgs[1]);
        int amount = Integer.valueOf(commandArgs[2]);
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            accounts.get(id).deposit(amount);
        }
    }

    private static void execCreate(String[] commandArgs, Map<Integer, BankAccount> accounts) {
        int id = Integer.valueOf(commandArgs[1]);
        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount();
            account.setId(id);
            accounts.put(id, account);
        }
    }
}
