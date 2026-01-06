public class CartItem {
    String itemName;
    double price;
    int quantity;
    void addItem(int q) {
        quantity += q;
        System.out.println("Added " + q + " of " + itemName + " to the cart.");
    }
    void removeItem(int q) {
        if (q <= quantity) {
            quantity -= q;
            System.out.println("Removed " + q + " of " + itemName + " from the cart.");
        }
    }
    double totalCost() {
        return price * quantity;
    }
    public static void main(String[] args) {
        CartItem c = new CartItem();
        c.itemName = "Laptop";
        c.price = 999.99;
        c.quantity = 1;
        System.out.println("Item: " + c.itemName + ", Price: $" + c.price + ", Quantity: " + c.quantity);
        c.addItem(2);
        c.removeItem(1);
        System.out.println("Total cost: $" + c.totalCost());
    }
}
