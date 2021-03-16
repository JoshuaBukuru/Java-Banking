package ATM;
import java.util.Date;
public class CheckingAccount extends Accounts {
    //A class that produces the check account details
    private double overdraft; //Stores overdraft limit

    public CheckingAccount(int id, Date dateCreated, double balance, double overdraft) {
        super(id, dateCreated, balance);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }
}
