import java.util.Scanner;

public class UnitConvertor2 {

    static double convertYardsToFeet(double yards){
        double y2f=3;
        return yards*y2f;
    }

    static double convertFeetToYards(double feet){
        double f2y=0.333333;
        return feet*f2y;
    }

    static double convertMetersToInches(double meters){
        double m2i=39.3701;
        return meters*m2i;
    }

    static double convertInchesToMeters(double inches){
        double i2m=0.0254;
        return inches*i2m;
    }

    static double convertInchesToCentimeters(double inches){
        double i2c=2.54;
        return inches*i2c;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double value=sc.nextDouble();

        System.out.println(convertYardsToFeet(value));
        System.out.println(convertFeetToYards(value));
        System.out.println(convertMetersToInches(value));
        System.out.println(convertInchesToMeters(value));
        System.out.println(convertInchesToCentimeters(value));
    }
}
