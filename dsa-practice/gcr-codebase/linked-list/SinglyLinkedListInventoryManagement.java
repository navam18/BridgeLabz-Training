class Item {
    int itemId;
    String name;
    int quantity;
    double price;
    Item next;

    Item(int id, String name, int qty, double price) {
        this.itemId = id;
        this.name = name;
        this.quantity = qty;
        this.price = price;
    }
}

class Inventory {
    private Item head;

    // Add item at end
    void addItem(Item item) {
        if (head == null) {
            head = item;
            return;
        }
        Item temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = item;
    }

    // Remove item by ID
    void removeById(int id) {
        Item curr = head, prev = null;

        while (curr != null) {
            if (curr.itemId == id) {
                if (prev == null) head = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Update quantity
    void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    // Search by ID
    Item searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Search by Name
    Item searchByName(String name) {
        Item temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Total inventory value
    double totalValue() {
        double sum = 0;
        Item temp = head;
        while (temp != null) {
            sum += temp.price * temp.quantity;
            temp = temp.next;
        }
        return sum;
    }

    // Display inventory
    void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.itemId + " | " + temp.name +
                    " | Qty: " + temp.quantity +
                    " | Price: " + temp.price);
            temp = temp.next;
        }
    }
}
public class SinglyLinkedListInventoryManagement {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItem(new Item(101, "Laptop", 5, 60000));
        inventory.addItem(new Item(102, "Mouse", 20, 500));
        inventory.addItem(new Item(103, "Keyboard", 10, 1500));

        inventory.displayInventory();
        inventory.updateQuantity(102, 25);
        System.out.println("Total Inventory Value: " + inventory.totalValue());
    }

}
