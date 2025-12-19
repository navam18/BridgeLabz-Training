import java.util.Scanner;
public class MultipleOfNumberUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 0 && n < 100) {
            int count = n - 1;
            while (count > 1) {
                if (n % count == 0) {
                    System.out.println(count);
                }
                count--;
            }
        }
    }
}
