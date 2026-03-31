import java.util.Scanner;
public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amarAge = sc.nextInt();
        int akbarAge = sc.nextInt();
        int anthonyAge = sc.nextInt();
        int amarHeight = sc.nextInt();
        int akbarHeight = sc.nextInt();
        int anthonyHeight = sc.nextInt();
        int youngest = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        if (youngest == amarAge)
            System.out.println("Amar is the youngest");
        else if (youngest == akbarAge)
            System.out.println("Akbar is the youngest");
        else
            System.out.println("Anthony is the youngest");
        int tallest = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        if (tallest == amarHeight)
            System.out.println("Amar is the tallest");
        else if (tallest == akbarHeight)
            System.out.println("Akbar is the tallest");
        else
            System.out.println("Anthony is the tallest");
    }
}
