import java.util.Scanner;
public class PowerOfNumberUsingWhile {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int power = sc.nextInt();
        int result = 1;
        int cnt = 0;
        while (cnt == power ? false : cnt < power) {
            result = result * n;
            cnt++;
        }
        System.out.println(result);
    }
}
