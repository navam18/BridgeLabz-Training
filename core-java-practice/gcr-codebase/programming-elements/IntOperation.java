import java.util.Scanner;
class IntOperation{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        int p=a+b*c;
        int  q=a*b+c;
        int r=c+a/b;
        int s=a%b+c;
        System.out.println(p+","+q+","+r+","+s);
    }
}