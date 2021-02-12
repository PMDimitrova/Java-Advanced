public class BankAccount {
    private static final double INTEREST_RATE = 0.02;
    private static double interestRate = INTEREST_RATE;
    private static int accountsCount = 1;
    private int id = 0;
    private double balance;

    public BankAccount() {
        this.id = accountsCount++;
        this.balance = 0.0;

    }

    public int getId() {
        return this.id;
    }

    public void deposit(double sumToDeposit) {
        this.balance += sumToDeposit;
    }

    static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public double getInterest(int years) {
        return BankAccount.interestRate * years * this.balance;
    }


}


