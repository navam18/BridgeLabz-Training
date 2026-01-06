
class ShoppingCartSystem{

    // Static variable
    static double discount = 10.0;

    // Instance variables
    final String productID;  // final
    String productName;
    double price;
    int quantity;

    // Constructor using this
    ShoppingCartSystem(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    void displayDetails(Object obj) {
        if (obj instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");

            double discountedPrice = price - (price * discount / 100);
            System.out.println("Price after Discount: $" + discountedPrice);
        }
    }

    public static void main(String[] args) {
        ShoppingCartSystem p1 = new ShoppingCartSystem("P001", "Laptop", 1200.0, 5);
        p1.displayDetails(p1);
    }
}

