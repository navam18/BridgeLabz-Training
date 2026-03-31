import java.util.*;

class ShoppingCart {

    Map<String, Double> priceMap = new HashMap<>();
    LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        priceMap.put(product, price);
        cart.put(product, cart.getOrDefault(product, 0) + 1);
    }

    public void displaySortedByPrice() {
        TreeMap<Double, List<String>> sorted = new TreeMap<>();

        for (String product : cart.keySet()) {
            sorted
                    .computeIfAbsent(priceMap.get(product), k -> new ArrayList<>())
                    .add(product);
        }

        System.out.println(sorted);
    }
}
public class ShoppingCarterApp {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct("Laptop", 80000);
        cart.addProduct("Mouse", 500);
        cart.addProduct("Keyboard", 1500);
        cart.addProduct("Mouse", 500);

        System.out.println("Cart Order:");
        System.out.println(cart.cart);

        System.out.println("Products sorted by price:");
        cart.displaySortedByPrice();
    }
}

