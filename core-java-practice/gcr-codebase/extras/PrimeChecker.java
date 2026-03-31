import java.util.Scanner;

class PrimeChecker {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int n=sc.nextInt();
        boolean result=isPrime(n);

        if(result){
            System.out.println("Prime number");
        }
        else{
            System.out.println("Not a prime number");
        }
    }

    static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
