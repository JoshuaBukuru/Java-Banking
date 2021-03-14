package ATM;

public class CheckingAccount extends Accounts {
    //A class that produces the check account details
    private double overdraft; //Stores overdraft limit

    public CheckingAccount(int id, double balance, double overdraft) {
        super(id, balance);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }
}
