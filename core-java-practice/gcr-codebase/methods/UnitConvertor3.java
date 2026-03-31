import java.util.Scanner;

public class UnitConvertor3 {

    static double convertFarhenheitToCelsius(double farhenheit){
        double f2c=(farhenheit-32)*5/9;
        return f2c;
    }

    static double convertCelsiusToFarhenheit(double celsius){
        double c2f=(celsius*9/5)+32;
        return c2f;
    }

    static double convertPoundsToKilograms(double pounds){
        double p2k=0.453592;
        return pounds*p2k;
    }

    static double convertKilogramsToPounds(double kilograms){
        double k2p=2.20462;
        return kilograms*k2p;
    }

    static double convertGallonsToLiters(double gallons){
        double g2l=3.78541;
        return gallons*g2l;
    }

    static double convertLitersToGallons(double liters){
        double l2g=0.264172;
        return liters*l2g;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double value=sc.nextDouble();

        System.out.println(convertFarhenheitToCelsius(value));
        System.out.println(convertCelsiusToFarhenheit(value));
        System.out.println(convertPoundsToKilograms(value));
        System.out.println(convertKilogramsToPounds(value));
        System.out.println(convertGallonsToLiters(value));
        System.out.println(convertLitersToGallons(value));
    }
}
