import java.util.*;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = Math.min(a.length(), b.length());
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                res = a.charAt(i) - b.charAt(i);
                break;
            }
        }
        if (res == 0) res = a.length() - b.length();
        if (res < 0) System.out.println(a + " comes before " + b);
        else if (res > 0) System.out.println(b + " comes before " + a);
        else System.out.println("Both strings are equal");
    }
}
