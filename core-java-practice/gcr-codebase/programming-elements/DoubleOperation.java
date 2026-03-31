import java.util.Scanner;
class DoubleOperation{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double a=sc.nextInt();
        double b=sc.nextDouble();
        double c=sc.nextInt();
        double p=a+b*c;
        double q=a*b+c;
        double r=c+a/b;
        double s=a%b+c;
        System.out.println(p+","+q+","+r+","+s);
    }
}