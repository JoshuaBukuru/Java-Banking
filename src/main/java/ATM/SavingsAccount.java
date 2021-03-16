package ATM;
import java.util.Date;
public class SavingsAccount extends Accounts {
    //A class that produces the savings account details
    private double annualInterestRate;

    public SavingsAccount(int id, Date dateCreated, double balance, double annualInterestRate) {
        super(id, dateCreated, balance);
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterestRate() {
        //Calculates the monthly interest rate
        return (this.annualInterestRate / 12) / 100;

    }
    public double getMonthlyInterest() {
        //Calculates the monthly interest
        return this.getBalance() * getMonthlyInterestRate();
    }

}
