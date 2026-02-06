import java.util.*;
import java.util.stream.*;

class Order {

    String customer;
    double amount;

    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    String getCustomer() {
        return customer;
    }

    double getAmount() {
        return amount;
    }
}

public class OrderRevenue {

    public static void main(String args[]) {

        List<Order> list = Arrays.asList(
                new Order("Rahul", 500),
                new Order("Ankit", 300),
                new Order("Rahul", 200),
                new Order("Neha", 400),
                new Order("Ankit", 100)
        );

        Map<String, Double> revenue =
                list.stream()
                    .collect(Collectors.groupingBy(
                            Order::getCustomer,
                            Collectors.summingDouble(Order::getAmount)
                    ));

        System.out.println(revenue);
    }
}
