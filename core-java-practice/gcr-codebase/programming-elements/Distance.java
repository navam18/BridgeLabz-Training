import java.util.Scanner;
class Distance{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double distanceInFeet=sc.nextDouble();
        double distanceInYard=distanceInFeet/3.0;
        double distanceInMiles=distanceInYard/1760.0;
        System.out.println("Your distance in feet is "+distanceInFeet+" ,in yards is "+distanceInYard+" and in miles is "+distanceInMiles);
    }
}