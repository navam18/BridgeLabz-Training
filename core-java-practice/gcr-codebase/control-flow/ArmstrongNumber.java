import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int originalNumber = num;
        int sum=0;
        while (originalNumber!=0) {
            int digit=originalNumber%10;
            sum=sum+(digit*digit*digit);
            originalNumber=originalNumber/10;
        }
        if(sum==num){
            System.out.println(num + " is an Armstrong Number");
        }
        else {
            System.out.println(num + " is NOT an Armstrong Number");
        }
    }
}
