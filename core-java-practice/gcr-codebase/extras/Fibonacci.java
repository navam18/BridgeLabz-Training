import java.util.Scanner;

class Fibonacci {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int n=sc.nextInt();
        generateFibonacci(n);
    }

    static void generateFibonacci(int n){
        int a=0;
        int b=1;
        for(int i=1;i<=n;i++){
            System.out.print(a+" ");
            int c=a+b;
            a=b;
            b=c;
        }
    }
}
