import java.util.Scanner;
public class CoffeeCounterChronicles {
    public static double getCoffeePrice(String coffeeType) {
        switch (coffeeType.toLowerCase()) {
            case "espresso":
                return 120.0;
            case "latte":
                return 150.0;
            case "cappuccino":
                return 180.0;
            default:
                return -1;
        }
    }
    public static double calculateTotal(double price, int quantity) {
        double bill = price * quantity;
        double gst = bill * 0.05;
        return bill + gst;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter coffee type (Espresso/Latte/Cappuccino) or 'exit': ");
            String coffeeType = sc.nextLine();
            if (coffeeType.equalsIgnoreCase("exit")) {
                System.out.println("Thank you!");
                break;
            }
            double price = getCoffeePrice(coffeeType);
            if (price == -1) {
                System.out.println("Invalid coffee type.");
                continue;
            }
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            double totalAmount = calculateTotal(price, quantity);
            System.out.println("Total Bill (including GST): ₹" + totalAmount);
        }
    }
}

