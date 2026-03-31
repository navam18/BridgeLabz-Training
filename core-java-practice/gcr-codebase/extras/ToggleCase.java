import java.util.*;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') sb.append((char)(c - 32));
            else if (c >= 'A' && c <= 'Z') sb.append((char)(c + 32));
            else sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
