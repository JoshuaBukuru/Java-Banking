package ATM;

public class SavingsAccount extends Accounts {
    private double annualInterestRate;

    public SavingsAccount(int id, double balance, double annualInterestRate) {
        super(id, balance);
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
