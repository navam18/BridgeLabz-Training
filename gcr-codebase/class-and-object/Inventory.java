public class Inventory {
        String itemCode;
        String itemName;
        double itemPrice;

        void displayItem() {
            System.out.println("itemCode : " + itemCode);
            System.out.println("itemPrice : " + itemPrice);
            System.out.println("itemName : " + itemName);
            System.out.println("----------------------------");
        }

        public static void main(String[] args) {
            Inventory i1 = new Inventory();
            i1.itemCode = "01AA";
            i1.itemPrice = 500.0;
            i1.itemName = "Water bottle";

            Inventory i2 = new Inventory();
            i2.itemCode = "01BB";
            i2.itemPrice = 700.0;
            i2.itemName = "Rice";

            Inventory i3 = new Inventory();
            i3.itemCode = "02AA";
            i3.itemPrice = 400.0;
            i3.itemName = "blackboard";

            i1.displayItem();
            i2.displayItem();
            i3.displayItem();
        }
    }
