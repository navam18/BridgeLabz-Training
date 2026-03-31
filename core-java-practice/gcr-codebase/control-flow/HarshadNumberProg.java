import java.util.Scanner;
public class HarshadNumberProg {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num= sc.nextInt();
        int origNum=num;
        int sum=0;
        while(num!=0){
            sum+=num% 10;
            num/= 10;
        }
        if(origNum%sum==0){
            System.out.println("Harshad Number");
        } else {
            System.out.println("Not a Harshad Number");
        }
    }
}

