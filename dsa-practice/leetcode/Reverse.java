import java.util.*;

class Reverse {

    public static int reverse(int x) {
        long r = 0;

        while (x != 0) {
            int d = x % 10;
            r = r * 10 + d;
            x = x / 10;

            if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) {
                return 0;
            }
        }
        return (int) r;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int x=sc.nextInt();
        int ans=reverse(x);

        System.out.println(ans);
    }
}
