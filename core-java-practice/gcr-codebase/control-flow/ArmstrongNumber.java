import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int origNumber = num;
        int sum=0;
        while (origNumber != 0) {
            int digit=origNumber % 10;
            sum=sum+(digit * digit * digit);
            origNumber=origNumber/ 10;
        }
        if(sum==num){
            System.out.println(num + " is an Armstrong Number");
        } else {
            System.out.println(num + " is NOT an Armstrong Number");
        }
    }
}
