import java.util.Scanner;
class FactorialUsingWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num<0) {
            System.out.println("Factorial is not defined for negative numbers");
        }
        else {
            int factorial = 1;
            int i = 1;
            while (i <= num) {
                factorial = factorial * i;
                i++;
            }
            System.out.println("Factorial of " + num + " = " + factorial);
        }
    }
}
