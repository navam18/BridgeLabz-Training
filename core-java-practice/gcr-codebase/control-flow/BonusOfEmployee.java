import java.util.Scanner;
public class BonusOfEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        int yearsOfService = sc.nextInt();
        double bonus = 0;
        if (yearsOfService > 5) {
            bonus = salary * 0.05;
        }
        System.out.println("Bonus amount is: " + bonus);
    }
}