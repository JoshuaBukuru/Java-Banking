import ATM.CheckingAccount;
import ATM.SavingsAccount;
import java.util.*;
import java.text.SimpleDateFormat;
public class main {
    public static void main(String[] args) {

        //Date created
        Date date_1 = new Date(121,7,22);
        Date date_2 = new Date(122,8,21);
        Date date_3 = new Date(120,7,31);
        Date date_4 = new Date(122,6,21);
        Date date_5 = new Date(121,4,21);
        Date date_6 = new Date(121,3,21);
        Date date_7 = new Date(120,1,9);
        Date date_8 = new Date(122,9,2);
        Date date_9 = new Date(122,12,1);
        Date date_10 = new Date(122,5,29);
        //Five savings accounts
        SavingsAccount savingsAccount_1 = new SavingsAccount(1,date_1,1000,10);
        SavingsAccount savingsAccount_2 = new SavingsAccount(2,date_2,1000,10);
        SavingsAccount savingsAccount_3 = new SavingsAccount(3,date_3,1000,10);
        SavingsAccount savingsAccount_4 = new SavingsAccount(4,date_4,1000,10);
        SavingsAccount savingsAccount_5 = new SavingsAccount(5,date_5,1000,10);
        //List for savings account
        List<SavingsAccount> savingAccounts = new ArrayList<>();
        savingAccounts.add(savingsAccount_1);
        savingAccounts.add(savingsAccount_2);
        savingAccounts.add(savingsAccount_3);
        savingAccounts.add(savingsAccount_4);
        savingAccounts.add(savingsAccount_5);

        //Five check accounts
        CheckingAccount checkingAccount_1 = new CheckingAccount(6,date_6,1000,900);
        CheckingAccount checkingAccount_2 = new CheckingAccount(7,date_7,1000,900);
        CheckingAccount checkingAccount_3 = new CheckingAccount(8,date_8,1000,900);
        CheckingAccount checkingAccount_4 = new CheckingAccount(9,date_9,1000,900);
        CheckingAccount checkingAccount_5 = new CheckingAccount(10,date_10,1000,900);
        //List for check accounts
        List checkingAccounts = new ArrayList();
        checkingAccounts.add(checkingAccount_1);
        checkingAccounts.add(checkingAccount_2);
        checkingAccounts.add(checkingAccount_3);
        checkingAccounts.add(checkingAccount_4);
        checkingAccounts.add(checkingAccount_5);


        Scanner sc= new Scanner(System.in);
        System.out.println("What type of account do you want utilise:\n1. check\n2. savings");
        int type = sc.nextInt();
        if(type == 1) {
            checkAccountMenu(checkingAccounts);
        } else if(type == 2){
            System.out.println("Enter the current date: format (dd-mm-yyyy)");
            String date = sc.next();
            savingAccountMenu(savingAccounts, date);
        } else {
            System.out.println("Enter a valid menu item");
        }



    }

    public static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();
    }

    public static void checkAccountMenu(List<CheckingAccount> checkingAccounts){
        //Menu for check accounts
        boolean run = true;                         //For eternal loop
        boolean foundId = false;                    //Tracks ID in stream of ID's

        Scanner sc = new Scanner(System.in);        //To read input
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
                System.out.println("Account Details");
                System.out.println("------------------------------");
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                System.out.println("Check account ID: "+ checkingAccount.getId());
                System.out.println("Date created: "+ sdf.format(checkingAccount.getDateCreated()));
                //System.out.println("Balance: R"+ checkingAccount.getBalance());
                System.out.println("------------------------------");
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
                    } else if((checkingAccount.getOverdraft() + checkingAccount.getBalance()) >= withdrawal) {
                        double amountLeft = checkingAccount.getBalance() - withdrawal;
                        checkingAccount.setBalance(amountLeft);
                    } else {
                        System.out.println("You have exceeded your overdraft limit!");
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

    public static void savingAccountMenu(List<SavingsAccount> savingAccounts, String date){
        //Menu for saving accounts
        boolean run = true;                         //For eternal loop
        boolean foundId = false;                    //Tracks ID in stream of ID's

        Scanner sc= new Scanner(System.in);         //To read input

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

                SavingsAccount savingsAccount = null;
                for(SavingsAccount savingAccountt : savingAccounts) {
                    if (savingAccountt.getId() == id) {
                        savingsAccount = savingAccountt;
                        break;
                    }
                }
                //To calculate the interest rate given the current date
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String[] dateArray = date.split("-");
                List <String> dateNow = Arrays.asList(dateArray);
                String dateCreated = sdf.format(savingsAccount.getDateCreated());
                String[] dateArray_2 = dateCreated.split("-");
                List <String> dateCreatedList = Arrays.asList(dateArray_2);

                int yearNow = Integer.parseInt(dateNow.get(2));
                int monthNow = Integer.parseInt(dateNow.get(1));
                int yearCreated = Integer.parseInt(dateCreatedList.get(2));
                int monthCreated = Integer.parseInt(dateCreatedList.get(1));

                int yearDiff = 0;
                int monthDiff = 0;
                double interestRate = 0;
                if(yearNow > yearCreated){
                    monthDiff = (((yearNow * 12) + monthNow) - ((yearCreated * 12) + monthCreated));

                }else if((yearNow == yearCreated) && (monthNow > monthCreated)) {
                    monthDiff = monthNow - monthCreated;
                } else{
                    interestRate = savingsAccount.getBalance();
                }
                interestRate = (savingsAccount.getMonthlyInterest() * monthDiff) + savingsAccount.getBalance();
                savingsAccount.setBalance(interestRate);
                System.out.println("Account Details");
                System.out.println("------------------------------");

                System.out.println("Check account ID: "+ savingsAccount.getId());
                System.out.println("Date created: "+ sdf.format(savingsAccount.getDateCreated()));
                //System.out.println("Balance: R"+ savingsAccount.getBalance());
                System.out.println("------------------------------");
                System.out.println("Main menu");
                System.out.println("1. check the balance");
                System.out.println("2. withdraw");
                System.out.println("3. deposit");
                System.out.println("4. exit\n");
                int menuPicker = sc.nextInt();

                if(menuPicker == 1) {
                    System.out.println("Your balance is: "+savingsAccount.getBalance());
                } else if(menuPicker == 2) {
                    System.out.println("Enter the amount for withdrawal:");
                    double withdrawal = sc.nextDouble();
                    if(savingsAccount.getBalance() >= withdrawal){
                        double amountLeft = savingsAccount.getBalance() - withdrawal;
                        savingsAccount.setBalance(amountLeft);
                    } else {
                        System.out.println("You have insufficient funds!");
                        continue;
                    }

                    System.out.println("Your requested withdrawal amount is: R" + withdrawal);

                }else if(menuPicker == 3) {
                    System.out.println("Enter the amount for deposit:");
                    double deposit = sc.nextDouble();
                    double balanceIncrease = savingsAccount.getBalance() + deposit;
                    savingsAccount.setBalance(balanceIncrease);
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

