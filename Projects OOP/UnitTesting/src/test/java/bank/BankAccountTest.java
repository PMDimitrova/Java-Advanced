package bank;

import org.junit.Assert;
import org.junit.Test;

public class BankAccountTest {
    @Test
    public void testBankAccountCreationStartsWitZeroBalance(){
        BankAccount bankAccount = new BankAccount();
        double balance = bankAccount.getBalance();

        Assert.assertEquals(0, balance,0);
    }

    @Test
    public void testDepositShouldIncreaseAmountCorrectly(){
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(300);
       Assert.assertEquals(300, bankAccount.getBalance(), 0);
    }
}
