import java.util.Scanner;
public class CountDigitsInAnInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num= sc.nextInt();
        int c=0;
        while (num != 0){
            num=num/ 10;
            c++;
        }
        System.out.println("Number of digits: " + c);
    }
}

