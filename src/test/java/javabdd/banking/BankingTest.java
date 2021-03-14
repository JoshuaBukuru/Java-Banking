package javabdd.banking;


import javabdd.banking.BankAccount;
//import javabdd.banking.WithdrawBalance;
import org.junit.Test;

public class BankingTest {
    //This is a UNIT Test

    @Test
    public void testWithDraw() {
        BankAccount bankAccount = new BankAccount("123");
        bankAccount.setAccountBalance(1000);
        bankAccount.setMinimumBalanceRequirement(100);
        //withdraw limit: 900
        WithdrawBalance withdrawBalance = new WithdrawBalance(bankAccount);
        assert withdrawBalance.withdrawAmount(900) > bankAccount.getMinimumBalanceRequirement();

    }
}
