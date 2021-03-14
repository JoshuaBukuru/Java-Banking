import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.java.sl.In;
import javabdd.banking.BankAccount;
import javabdd.banking.WithdrawBalance;



public class StepDefinitions {
    BankAccount bankAccount = new BankAccount("123");

    //setup the steps
    @Given("Account balance is {string}")
    public void isAccountBalanceNotZero(String accountBalance) {
        bankAccount.setAccountBalance(Integer.parseInt(accountBalance));

    }
    @When("Minimum account balance to maintain is {string}")
    public void isMinimumBalanceMaintained(String minBalance){
        bankAccount.setMinimumBalanceRequirement(Integer.parseInt(minBalance));

    }
    @Then("Successfully withdraw {string}")
    public void withdrawBalance(String amount) {
        WithdrawBalance withdraw = new WithdrawBalance(bankAccount);
        assert withdraw.withdrawAmount(Integer.parseInt(amount)) > 0;

    }


}
