import java.util.Scanner;
class KM2Miles3{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double km=sc.nextDouble();
        double miles=1.6*km;
        System.out.println("The distance "+km+" km in miles is "+miles);
    }
}