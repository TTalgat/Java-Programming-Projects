
class Bank {
    public int getBalance(){
        int balance = 0;
        return balance;
    }
}

class BankA extends Bank {
    public int getBalance(){
        int balanceA = 1250;
        return balanceA;
    }
}

class BankB extends Bank {
    public int getBalance(){
        int balanceB = 2500;
        return balanceB;
    }
}

class BankC extends Bank {
    public int getBalance() {
        int balanceC = 3200;
        return balanceC;
    }
}
public class BankDeposit {
    public static void main(String[] args) {
        Bank bankA = new BankA();
        Bank bankB = new BankB();
        Bank bankC = new BankC();
        System.out.println("Bank A deposit RM" + bankA.getBalance());
        System.out.println("Bank B deposit RM" + bankB.getBalance());
        System.out.println("Bank C deposit RM" + bankC.getBalance());
    }
}

