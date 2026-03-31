import java.util.Scanner;

public class UnitConvertor1 {

    static double convertKmToMiles(double km){
        double km2m=0.621371;
        return km*km2m;
    }

    static double convertMilesToKm(double miles){
        double m2k=1.60934;
        return miles*m2k;
    }

    static double convertMetersToFeet(double meters){
        double m2f=3.28084;
        return meters*m2f;
    }

    static double convertFeetToMeters(double feet){
        double f2m=0.3048;
        return feet*f2m;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double value=sc.nextDouble();

        System.out.println(convertKmToMiles(value));
        System.out.println(convertMilesToKm(value));
        System.out.println(convertMetersToFeet(value));
        System.out.println(convertFeetToMeters(value));
    }
}
