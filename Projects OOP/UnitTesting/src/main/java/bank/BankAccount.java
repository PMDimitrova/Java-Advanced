package bank;

public class BankAccount {
    private double balance;

    public BankAccount(){
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit (double money){
        this.balance += money;
    }
}
