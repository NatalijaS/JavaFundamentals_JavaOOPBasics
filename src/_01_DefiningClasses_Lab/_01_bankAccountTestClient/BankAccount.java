package _01_DefiningClasses_Lab._01_bankAccountTestClient;

public class BankAccount {
    private int id;
    private double balance;

    public void setId(int id) {
        this.id = id;
    }

    double getBalance() {
        return balance;
    }

    void deposit(double amound) {
        this.balance += amound;
    }

    void withdraw(double amound) {
        this.balance -= amound;
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }
}
