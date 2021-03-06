package ATM;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Accounts {
    private int id;
    private double balance;
    private Date dateCreated;

    public Accounts(int id, Date dateCreated, double balance) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.balance = balance;

    }
    public double withdraw(double amount) {
        return amount;
    }
    public double deposit(double deposit) {
        return deposit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
