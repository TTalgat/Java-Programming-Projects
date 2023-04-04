import java.util.InputMismatchException;
import java.util.Scanner;

class BankAccount{
    private static String bankName;
    private String fullName;
    private int accountNumber;
    private String accountType;
    private double interestRate;
    private double balance;

    public BankAccount(){
        bankName = "ABC bank";
        fullName = "Unknown";
        accountNumber = 123;
        accountType = "Unknown";
        interestRate = 0.0;
        balance = 0.0;
    }
    public BankAccount(String bankName, String fullName, int accountNumber, int accountType,
                       double interestRate, double balance){
        this();
        bankName = bankName;
        fullName = fullName;
        accountNumber = accountNumber;
        accountType = accountType;
        interestRate = interestRate;
        balance = balance;
    }

    public static String getBankName() {
        return bankName;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public double getBalance() {
        return balance;
    }

    public static void setBankName(String bankName) {
        BankAccount.bankName = bankName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String toString(){
        return ("Bank Name: " + bankName + "\nFull Name: "+ fullName
                + "\nAccount Number: " + accountNumber + "\nAccount Type: " + accountType
                + "\nInterest Rate: " + interestRate + "\nBalance: " + balance);
    }
    public void deposit(double deposit){
        balance = balance + deposit;
    }
    public void withDraw(double drawMoney){
        balance = balance - drawMoney;
    }
    public void Transfer(double transMoney){
        balance = balance - transMoney;
    }
    public void display(){
        System.out.println("Bank Name: "+ getBankName() + "\nFull Name: " + getFullName() +
                "\nBalance: " + getBalance());
    }
}
class SavingAccount extends BankAccount{
    public SavingAccount() {
        super.setBalance(50);
        super.setInterestRate(0.05);
    }
}
class CurrentAccount extends BankAccount{

    public CurrentAccount() {
        super.setBalance(200);
        super.setInterestRate(0.01);
    }
}

public class BankInfo {
    static void createAccount(BankAccount[] accounts){
        Scanner inputChoice = new Scanner(System.in);
        BankAccount bank = new BankAccount();
        System.out.print("Enter Your Full Name: ");
        String fullName = inputChoice.nextLine();
        int numberMin = 1001;
        int numberMax = 9999;
        int int_random = (int)Math.floor(Math.random()*(numberMax-numberMin + 1) + numberMin);
        System.out.println("1. Current Account: " + "\n2. Saving Account: " + "\n0. End of Program.\n");
        System.out.print("Enter Your Choice: ");
        int choice = inputChoice.nextInt();
        switch (choice){
            case 1:
                bank = new CurrentAccount();
                bank.setAccountNumber(int_random);
                bank.setAccountType("Current");
                bank.setFullName(fullName);

                break;
            case 2:
                bank = new SavingAccount();
                bank.setFullName(fullName);
                bank.setAccountNumber(int_random);
                bank.setAccountType("Saving");
                break;
        }
        int count = 0;
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i] != null){
                count++;
            }
        }
        accounts[count] = bank;
        System.out.println("Full Name: " + bank.getFullName() + "\nAccount Number: " +
                bank.getAccountNumber() + "\nAccount Type: " + bank.getAccountType());


    }
    public static void main(String[] args) {
        BankAccount[] accounts = new BankAccount[10];
        while (true) {
            System.out.println("\n--------Menu--------\n" + "1. Create an Account: " +
                    "\n2. Make a transaction: "+ "\nEnd the program inserting 0: \n");
            Scanner inputChoice = new Scanner(System.in);
            System.out.print("Enter Your Choice: ");
            int choice = inputChoice.nextInt();
            if(choice == 0){
                System.out.println("--------End of program--------");
                break;
            }
            switch (choice) {
                case 1:
                    createAccount(accounts);
                    break;
                case 2:
                    Transaction(accounts);
                    break;
            }
        }
    }

    static void Transaction(BankAccount[] accounts) {
        BankAccount bankAccount;
        BankAccount receiverBank;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter Account Number: ");
        int accountNumber = scan.nextInt();
        for(int i = 0; i < accounts.length; i++){
            if(accounts[i]==null){
                break;
            }
            if(accounts[i].getAccountNumber() == accountNumber){

                bankAccount = accounts[i];
                while (true){
                    System.out.println("1.Display: " + "\n2.Deposit: " + "\n3.WithDraw: "
                            + "\n4. Transfer: " + "\n0. Exit: ");
                    System.out.print("Enter Your Choice: ");
                    int choice = scan.nextInt();
                    if(choice == 0)
                        break;
                    switch (choice){
                        case 1:
                            System.out.println(bankAccount);
                            break;
                        case 2:
                            System.out.println("How much for deposit: ");
                            double deposit = scan.nextDouble();
                            bankAccount.deposit(deposit);
                            break;
                        case 3:
                            System.out.println("How much you withDraw: ");
                            double withDraw = scan.nextDouble();
                            bankAccount.withDraw(withDraw);
                            break;
                        case 4:
                            boolean done = false;
                            while (!done) {
                                try {
                                    System.out.print("How much you transfer: ");
                                    double transfer = scan.nextDouble();
                                    if(transfer > bankAccount.getBalance() && transfer == 0){
                                        System.out.println("Unsuccessful\n\n");
                                        break;
                                    }
                                    System.out.print("Enter receiver number: ");
                                    int receiveNum = scan.nextInt();
                                    for (int j = 0; j < accounts.length; i++) {
                                        if (accounts[i] == null) break;
                                        if (accounts[j].getAccountNumber() == receiveNum) {
                                            receiverBank = accounts[j];
                                            bankAccount.withDraw(transfer);
                                            receiverBank.deposit(transfer);
                                        }
                                    }
                                    done = true;
                                    System.out.println("Successful.");
                                    break;
                                } catch (InputMismatchException e){
                                    scan.next();
                                    System.out.println("Unsuccessful");
                                }
                            }
                    }

                }
            }
        }
    }
}
