import java.util.*;

public class SubstringCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String sub = sc.nextLine();
        int count = 0;
        for (int i = 0; i <= s.length() - sub.length(); i++) {
            boolean ok = true;
            for (int j = 0; j < sub.length(); j++) {
                if (s.charAt(i + j) != sub.charAt(j)) {
                    ok = false;
                    break;
                }
            }
            if (ok) count++;
        }
        System.out.println(count);
    }
}
