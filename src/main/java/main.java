import ATM.SavingsAccount;
public class main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(123,1000,10);
        System.out.println(savingsAccount.getMonthlyInterest());
    }
}
