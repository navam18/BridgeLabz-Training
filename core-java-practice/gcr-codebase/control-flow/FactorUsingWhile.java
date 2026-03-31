import java.util.Scanner;
public class FactorUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0) {
            int count = 1;
            while (count < n) {
                if (n % count == 0) {
                    System.out.println(count);
                }
                count++;
            }
        } 
    }
}
