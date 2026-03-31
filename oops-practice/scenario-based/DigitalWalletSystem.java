import java.util.*;


class InsufficientBalanceExceptionn extends Exception {
    public InsufficientBalanceExceptionn(String msg) {
        super(msg);
    }
}

interface TransferService {
    void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException;
}

class WalletTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {
        from.withdraw(amount);
        to.addMoney(amount);
        System.out.println("Wallet to Wallet transfer successful");
    }
}


class BankTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount)
            throws InsufficientBalanceException {
        from.withdraw(amount + 50); // bank fee
        to.addMoney(amount);
        System.out.println("Bank transfer successful (₹50 fee applied)");
    }
}


class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

class Wallet {
    double balance;
    List<Transaction> transactions = new ArrayList<>();

    void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("Credit", amount));
    }

    void withdraw(double amount) throws InsufficientBalanceExceptionn {
        if (balance < amount)
            throw new InsufficientBalanceExceptionn("Insufficient balance");
        balance -= amount;
        transactions.add(new Transaction("Debit", amount));
    }

    void showTransactions() {
        for (Transaction t : transactions) {
            System.out.println(t.type + " : ₹" + t.amount);
        }
    }
}

class Userr {
    int userId;
    String name;
    Wallet wallet = new Wallet();

    Userr(int id, String name) {
        this.userId = id;
        this.name = name;
    }
}

// ================= Main Driver =================
public class DigitalWalletSystem {
    public static void main(String[] args) {

        Userr u1 = new Userr(1, "Rahul");
        Userr u2 = new Userr(2, "Neha");

        u1.wallet.addMoney(5000);

        TransferService transfer = new WalletTransfer();

        try {
            transfer.transfer(u1.wallet, u2.wallet, 2000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Rahul Transactions:");
        u1.wallet.showTransactions();

        System.out.println("Neha Transactions:");
        u2.wallet.showTransactions();
    }
}

