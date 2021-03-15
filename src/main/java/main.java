import ATM.CheckingAccount;
import ATM.SavingsAccount;
import java.util.*;
public class main {





    public static void main(String[] args) {

        //Five savings accounts
        SavingsAccount savingsAccount_1 = new SavingsAccount(1,1000,10);
        SavingsAccount savingsAccount_2 = new SavingsAccount(2,1000,10);
        SavingsAccount savingsAccount_3 = new SavingsAccount(3,1000,10);
        SavingsAccount savingsAccount_4 = new SavingsAccount(4,1000,10);
        SavingsAccount savingsAccount_5 = new SavingsAccount(5,1000,10);
        //List for savings account
        List<SavingsAccount> savingAccounts = new ArrayList<>();
        savingAccounts.add(savingsAccount_1);
        savingAccounts.add(savingsAccount_2);
        savingAccounts.add(savingsAccount_3);
        savingAccounts.add(savingsAccount_4);
        savingAccounts.add(savingsAccount_5);

        //Five check accounts
        CheckingAccount checkingAccount_1 = new CheckingAccount(6,1000,900);
        CheckingAccount checkingAccount_2 = new CheckingAccount(7,1000,900);
        CheckingAccount checkingAccount_3 = new CheckingAccount(8,1000,900);
        CheckingAccount checkingAccount_4 = new CheckingAccount(9,1000,900);
        CheckingAccount checkingAccount_5 = new CheckingAccount(10,1000,900);
        //List for check accounts
        List checkingAccounts = new ArrayList();
        checkingAccounts.add(checkingAccount_1);
        checkingAccounts.add(checkingAccount_2);
        checkingAccounts.add(checkingAccount_3);
        checkingAccounts.add(checkingAccount_4);
        checkingAccounts.add(checkingAccount_5);


        checkAccountMenu(checkingAccounts);




    }

    public static void checkAccountMenu(List<CheckingAccount> checkingAccounts){
        //Menu for check accounts
        boolean run = true;                       //For eternal loop
        boolean foundId = false;                    //Tracks ID in stream of ID's

        Scanner sc = new Scanner(System.in);       //To read input
        while (run) {
            System.out.print("Enter your ID: ");
            int id = sc.nextInt();

            for(CheckingAccount checkingAccount : checkingAccounts){
                if(id == checkingAccount.getId()) {
                    foundId = true;
                    break;
                } else {
                    foundId = false;
                }
            }
            if( foundId ) {
                //Main menu

                CheckingAccount checkingAccount = null;
                for(CheckingAccount checkingAccountt : checkingAccounts) {
                    if (checkingAccountt.getId() == id) {
                         checkingAccount = checkingAccountt;
                         break;
                    }
                }

                System.out.println("Main menu");
                System.out.println("1. check the balance");
                System.out.println("2. withdraw");
                System.out.println("3. deposit");
                System.out.println("4. exit\n");
                int menuPicker = sc.nextInt();

                if(menuPicker == 1) {
                    System.out.println("Your balance is: "+checkingAccount.getBalance());
                } else if(menuPicker == 2) {
                    System.out.println("Enter the amount for withdrawal:");
                    double withdrawal = sc.nextDouble();
                    if(checkingAccount.getBalance() >= withdrawal){
                        double amountLeft = checkingAccount.getBalance() - withdrawal;
                        checkingAccount.setBalance(amountLeft);
                    } else {
                        System.out.println("You have insufficient funds!");
                        continue;
                    }

                    System.out.println("Your requested withdrawal amount is: R" + withdrawal);

                }else if(menuPicker == 3) {
                    System.out.println("Enter the amount for deposit:");
                    double deposit = sc.nextDouble();
                    double balanceIncrease = checkingAccount.getBalance() + deposit;
                    checkingAccount.setBalance(balanceIncrease);
                    System.out.println("You've deposited R" + deposit);

                } else if(menuPicker == 4) {
                    continue;

                } else {
                    System.out.println("Enter a valid item number!");
                    continue;
                }


            } else {
                System.out.println("Please enter a valid ID");
                continue;
            }
        }


    }

    public static void savingAccountMenu(List<SavingsAccount> savingAccounts){
        //Menu for saving accounts
        boolean run = true;                       //For eternal loop
        boolean foundId = false;                    //Tracks ID in stream of ID's

        Scanner sc= new Scanner(System.in);       //To read input
        for(SavingsAccount savingAccount : savingAccounts){
            System.out.println(savingAccount.getId());
        }

        while (run) {
            System.out.print("Enter your ID: ");
            int id = sc.nextInt();

            for(SavingsAccount savingAccount : savingAccounts){
                if(id == savingAccount.getId()) {
                    foundId = true;
                    break;
                } else {
                    foundId = false;
                }
            }
            if( foundId ) {
                //Main menu
                SavingsAccount savingAccount = savingAccounts.get(id);
                System.out.println("Main menu");
                System.out.println("1. check the balance");
                System.out.println("2. withdraw");
                System.out.println("3. deposit");
                System.out.println("4. exit\n");
                int menuPicker = sc.nextInt();

                if(menuPicker == 1) {
                    System.out.println("Your balance is: "+savingAccount.getBalance());
                } else if(menuPicker == 2) {
                    System.out.println("Enter the amount for withdrawal:");
                    double withdrawal = sc.nextDouble();
                    if(savingAccount.getBalance() >= withdrawal){
                        double amountLeft = savingAccount.getBalance() - withdrawal;
                        savingAccount.setBalance(amountLeft);
                    } else {
                        System.out.println("You have insufficient funds!");
                        continue;
                    }

                    System.out.println("Your requested withdrawal amount is: R" + withdrawal);

                }else if(menuPicker == 3) {
                    System.out.println("Enter the amount for deposit:");
                    double deposit = sc.nextDouble();
                    double balanceIncrease = savingAccount.getBalance() + deposit;
                    savingAccount.setBalance(balanceIncrease);
                    System.out.println("You've deposited R" + deposit);

                } else if(menuPicker == 4) {
                    continue;

                } else {
                    System.out.println("Enter a valid item number!");
                    continue;
                }


            } else {
                System.out.println("Please enter a valid ID");
                continue;
            }
        }


    }
}

