import java.util.*;

class BankingSystem {

    Map<String, Double> accounts = new HashMap<>();
    Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accNo, double balance) {
        accounts.put(accNo, balance);
    }

    public void requestWithdrawal(String accNo) {
        withdrawalQueue.offer(accNo);
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.poll();
            accounts.put(acc, accounts.get(acc) - amount);
        }
    }

    public void sortAccountsByBalance() {
        TreeMap<Double, List<String>> sorted = new TreeMap<>();

        for (Map.Entry<String, Double> e : accounts.entrySet()) {
            sorted
                    .computeIfAbsent(e.getValue(), k -> new ArrayList<>())
                    .add(e.getKey());
        }

        System.out.println(sorted);
    }
}
public class BankingApp {

    public static void main(String[] args) {

        BankingSystem bank = new BankingSystem();

        bank.addAccount("ACC101", 5000);
        bank.addAccount("ACC102", 12000);
        bank.addAccount("ACC103", 8000);

        bank.requestWithdrawal("ACC101");
        bank.requestWithdrawal("ACC103");

        bank.processWithdrawals(2000);

        System.out.println("Accounts after withdrawals:");
        System.out.println(bank.accounts);

        System.out.println("Accounts sorted by balance:");
        bank.sortAccountsByBalance();
    }
}
