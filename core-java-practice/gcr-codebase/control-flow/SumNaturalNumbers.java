import java.util.Scanner;
class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.out.println("Not a natural number");
        } 
        else {
            int sumWhile = 0;
            int i = 1;
            while (i <= n) {
                sumWhile = sumWhile+i;
                i++;
            }
            int sumFormula = n*(n+1)/2;
            System.out.println("Sum using while loop = " + sumWhile);
            System.out.println("Sum using formula   = " + sumFormula);
            if (sumWhile==sumFormula) {
                System.out.println("Both computations are correct");
            }
            else{
                System.out.println("Both computations are not correct");
            }
        }
    }
}
