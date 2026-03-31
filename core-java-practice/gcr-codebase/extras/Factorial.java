import java.util.Scanner;

class Factorial {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int n=sc.nextInt();
        int result=factorial(n);
        System.out.println(result);
    }

    static int factorial(int n){
        if(n==0){
            return 1;
        }
        return n*factorial(n-1);
    }
}
