import java.util.Scanner;

class GcdLcmCalculator {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int a=sc.nextInt();
        int b=sc.nextInt();

        int gcd=findGcd(a,b);
        int lcm=findLcm(a,b);

        System.out.println("GCD = "+gcd);
        System.out.println("LCM = "+lcm);
    }

    static int findGcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }

    static int findLcm(int a,int b){
        return (a*b)/findGcd(a,b);
    }
}
