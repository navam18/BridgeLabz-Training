public class BankAccount {
    String accountHolder;
    String accountNumber;
    double balance;
    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current balance: " + balance);
    }
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw amount is : " + amount);
            System.out.println("Current balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.accountHolder = "State of Chennai";
        acc.accountNumber = "ACC001";
        acc.balance = 700;
        System.out.println(acc.accountHolder);
        acc.displayBalance();
        acc.deposit(200);
        acc.withdraw(100);
        acc.withdraw(1000);
    }
}
