import java.util.Scanner;
class TriangleArea{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double base=sc.nextInt();
        double height=sc.nextInt();
        double areaSqInch=0.5*base*height;
        double areaSqCM=areaSqInch*6.4516;
        System.out.println("Your height in cm is "+height+" while in feet is "+areaSqCM+" while in inches is "+areaSqInch);
    }
}