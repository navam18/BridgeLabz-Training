class MathUtility{
    public static long factorial(int n){
        if(n<0)return -1;
        long result=1;
        for(int i=1;i<=n;i++){
            result*=i;
        }
        return result;
    }
    public static boolean isPrime(int n){
        if(n<=1)return false;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static int gcd(int a,int b){
        a=Math.abs(a);
        b=Math.abs(b);
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static int fibonacci(int n){
        if(n<0)return -1;
        if(n==0)return 0;
        if(n==1)return 1;
        int a=0;
        int b=1;
        for(int i=2;i<=n;i++){
            int c=a+b;
            a=b;
            b=c;
        }
        return b;
    }
    public static void main(String[] args){
        System.out.println(factorial(5));
        System.out.println(factorial(0));
        System.out.println(factorial(-3));
        System.out.println(isPrime(7));
        System.out.println(isPrime(1));
        System.out.println(isPrime(-5));
        System.out.println(gcd(54,24));
        System.out.println(gcd(-8,12));
        System.out.println(fibonacci(10));
        System.out.println(fibonacci(1));
        System.out.println(fibonacci(-4));
    }
}
