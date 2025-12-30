import java.util.Scanner;
public class BMIFitnessTracker {
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
    public static String getBMICategory(double bmi) {
        if (bmi<18.5) {
            return "Underweight";
        } else if (bmi<25) {
            return "Normal";
        } else {
            return "Overweight";
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();
        System.out.print("Enter height in meters: ");
        double height = sc.nextDouble();
        double bmi = calculateBMI(weight, height);
        String category = getBMICategory(bmi);
        System.out.printf("BMI: %.2f\n", bmi);
        System.out.println("Category: " + category);
    }
}

