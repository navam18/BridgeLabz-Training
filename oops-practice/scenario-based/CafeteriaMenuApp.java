import java.util.Scanner;

class CafeteriaMenuApp {

    static void displayMenu(String[] items) {
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + " : " + items[i]);
        }
    }

    static String getItemByIndex(String[] items, int index) {
        return items[index];
    }

    public static void main(String[] args) {
        String[] items = {
            "Burger","Pizza","Sandwich","Pasta","Noodles",
            "Coffee","Tea","Juice","Fries","Ice Cream"
        };

        Scanner sc = new Scanner(System.in);
        displayMenu(items);
        int choice = sc.nextInt();
        System.out.println(getItemByIndex(items, choice));
    }
}
