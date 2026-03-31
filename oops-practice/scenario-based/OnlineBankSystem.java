import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InsufficientBalanceException extends RuntimeException{

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
interface BankService{

    void createAccount(Account account);
    double checkBalance(int accountNumber);
    void transferFunds(int fromAcc, int toAcc, double amount)
            throws InsufficientBalanceException;
    void showTransactionHistory(int accountNumber);
}
abstract class Account{

    protected String accountNumber;
    protected String holderName;
    protected double balance;
    protected List<String> transactionHistory = new ArrayList<>();

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: ₹" + amount);
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    // Polymorphism
    public abstract double calculateInterest();
}
class SavingsAccountC extends Account{
    public SavingsAccountC(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }
}
class CurrentAccount extends Account{
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.01; // 4% interest
    }
}
class BankServiceImpl implements BankService {

    private Map<String, Account> accounts = new HashMap<>();

    @Override
    public void createAccount(Account account) {
        accounts.put(account.accountNumber, account);
        System.out.println("Account created for " + account.holderName);
    }

    @Override
    public double checkBalance(int accountNumber) {
        return accounts.get(accountNumber).getBalance();
    }

    @Override
    public synchronized void transferFunds(int fromAcc, int toAcc, double amount)
            throws InsufficientBalanceException {

        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        sender.withdraw(amount);
        receiver.deposit(amount);

        sender.transactionHistory.add("Transferred ₹" + amount + " to A/C " + toAcc);
        receiver.transactionHistory.add("Received ₹" + amount + " from A/C " + fromAcc);
    }

    @Override
    public void showTransactionHistory(int accountNumber) {
        Account acc = accounts.get(accountNumber);
        System.out.println("\nTransaction History for A/C " + accountNumber);
        for (String tx : acc.getTransactionHistory()) {
            System.out.println(tx);
        }
    }
}
public class OnlineBankSystem {
    public static void main(String[] args) {
        BankService bank = new BankServiceImpl();

        Account acc1 = new SavingsAccountC("101", "Divyansh", 50000);
        Account acc2 = new CurrentAccount("102", "Rohan", 30000);

        bank.createAccount(acc1);
        bank.createAccount(acc2);

        try {
            bank.transferFunds(101, 102, 10000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nBalance of 101: " + bank.checkBalance(101));
        System.out.println("Balance of 102: " + bank.checkBalance(102));

        System.out.println("\nInterest for 101: " + acc1.calculateInterest());
        System.out.println("Interest for 102: " + acc2.calculateInterest());

        bank.showTransactionHistory(101);
        bank.showTransactionHistory(102);
    }


}
