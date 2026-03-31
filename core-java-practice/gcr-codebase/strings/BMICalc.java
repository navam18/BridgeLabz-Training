import java.util.Scanner;

public class BMICalc {

    // Method to calculate BMI and Status for one person
    public static String[] calculateBMIAndStatus(double w, double hCm) {
        double hm=hCm/100;
        double bmi=w/(hm*hm);

        String status;
        if(bmi<18.5){
            status="Underweight";
        }else if(bmi<25){
            status="Normal";
        }else if(bmi<30){
            status="Overweight";
        }else{
            status="Obese";
        }

        return new String[]{
                String.format("%.2f",hCm),
                String.format("%.2f",w),
                String.format("%.2f",bmi),
                status
        };
    }

    // Method to process all persons
    public static String[][] processBMI(double[][] data) {
        String[][] res=new String[10][4];
        for(int i=0;i<10; i++){
            res[i]=calculateBMIAndStatus(data[i][0],data[i][1]);
        }
        return res;
    }

    // Method to display result in tabular format
    public static void displayBMIReport(String[][] report) {
        System.out.println("\nHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
        for(int i=0;i<report.length;i++) {
            System.out.println(
                    report[i][0] + "\t\t" +
                            report[i][1] + "\t\t" +
                            report[i][2] + "\t" +
                            report[i][3]
            );
        }
    }
    // Main method
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double[][] drr= new double[10][2]; // [weight, height]
        System.out.println("Enter weight (kg) and height (cm) for 10 persons:");
        for (int i = 0; i < 10; i++) {
            System.out.println("\nPerson " + (i + 1));
            System.out.print("Weight (kg): ");
            drr[i][0]=sc.nextDouble();
            System.out.print("Height (cm): ");
            drr[i][1]=sc.nextDouble();
        }
        String[][] bmiReport = processBMI(drr);
        displayBMIReport(bmiReport);
    }
}
