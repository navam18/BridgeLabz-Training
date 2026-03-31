import java.util.Scanner;
public class GreatestFactorUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int greatestFactor = 1;
        int cnt = n - 1;
        while (cnt >= 1) {
            if (n % cnt == 0) {
                greatestFactor = cnt;
                break;
            }
            cnt--;
        }
        System.out.println("Greatest factor " + greatestFactor);
    }
}
