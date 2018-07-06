package _01_DefiningClasses_Lab._02_staticIdAndInterestRate;

public class BankAccount {
    private final static double DEFAULT_INTEREST = 0.02;
    private static double rate = DEFAULT_INTEREST;
    private static int bankAccountCount;

    private Integer id;
    private Double balance = 0.0;


    BankAccount() {
        this.id = ++bankAccountCount;
    }

    Double getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    static void setInterest(Double interest) {
        rate = interest;
    }

    double getInterest(int years) {
        return this.balance * rate * years;
    }

    void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Deposit amount must be non-negative.");
            return;
        }
        this.balance += amount;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
