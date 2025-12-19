import java.util.Scanner;
public class BmiCalc{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double we= sc.nextDouble();
        double heCm = sc.nextDouble();
        double heightInMeter = heCm / 100;
        double bmi=we/(heightInMeter*heightInMeter);
        System.out.println("BMI is: " + bmi);
        if(bmi<18.5)
            System.out.println("Underweight");
        else if (bmi<25)
            System.out.println("Normal weight");
        else if (bmi<40)
            System.out.println("Overweight");
        else
            System.out.println("Obese");
    }
}
