import java.util.Scanner;
class FirstIsSmallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        if (n1 < n2 && n1 < n3) {
            System.out.println("Is the first number the smallest? Yes");
        }
        else {
            System.out.println("Is the first number the smallest? No");
        }
    }
}
