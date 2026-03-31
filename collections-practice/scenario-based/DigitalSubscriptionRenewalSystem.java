import java.time.LocalDate;
import java.util.*;

class PaymentDeclinedException extends Exception {
    PaymentDeclinedException(String message) {
        super(message);
    }
}

interface DiscountStrategy {
    double applyDiscount(double amount);
}

class NoDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount;
    }
}

class PremiumDiscount implements DiscountStrategy {
    public double applyDiscount(double amount) {
        return amount * 0.8; 
    }
}

class User {

    private int userId;
    private String name;
    private LocalDate expiryDate;
    private boolean autoRenew;
    private double subscriptionFee;
    private DiscountStrategy discountStrategy;

    User(int userId, String name, LocalDate expiryDate,
            boolean autoRenew, double subscriptionFee,
            DiscountStrategy discountStrategy) {
        this.userId = userId;
        this.name = name;
        this.expiryDate = expiryDate;
        this.autoRenew = autoRenew;
        this.subscriptionFee = subscriptionFee;
        this.discountStrategy = discountStrategy;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public String getName() {
        return name;
    }

    public void renewSubscription() throws PaymentDeclinedException {

        double finalAmount = discountStrategy.applyDiscount(subscriptionFee);

        if (finalAmount > 5000) {
            throw new PaymentDeclinedException("Payment declined for user: " + name);
        }

        expiryDate = expiryDate.plusMonths(1);

        System.out.println("Subscription renewed for " + name +" | Amount Paid: " + finalAmount +" | New Expiry: " + expiryDate);
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public String toString() {
        return "User: " + name + ", Expiry: " + expiryDate +", AutoRenew: " + autoRenew;
    }
}

class SubscriptionManager {

    private List<User> users;

    SubscriptionManager() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void processRenewals() {

        for (User user : users) {

            if (user.isAutoRenew() && user.isExpired()) {
                try {
                    user.renewSubscription();
                }
                catch (PaymentDeclinedException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void showExpiredUsers() {

        System.out.println("Expired Accounts:");

        users.stream()
            .filter(User::isExpired)
            .forEach(System.out::println);
    }
}

public class DigitalSubscriptionRenewalSystem {

    public static void main(String[] args) {

        SubscriptionManager manager = new SubscriptionManager();

        User u1 = new User(
                1,
                "Rahul",
                LocalDate.now().minusDays(1),
                true,
                1000,
                new PremiumDiscount()
        );

        User u2 = new User(
                2,
                "Aman",
                LocalDate.now().minusDays(2),
                false,
                2000,
                new NoDiscount()
        );

        User u3 = new User(
                3,
                "Priya",
                LocalDate.now().minusDays(3),
                true,
                6000,
                new NoDiscount()
        );

        manager.addUser(u1);
        manager.addUser(u2);
        manager.addUser(u3);

        manager.processRenewals();

        System.out.println();
        manager.showExpiredUsers();
    }
}
