import java.util.Scanner;   
class BMI{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of persons: ");
        int n=sc.nextInt();
        double[] weight=new double[n];
        double[] height=new double[n];
        double[] bmi=new double[n];
        String[] status=new String[n];
        for(int i=0;i<n;i++){
            System.out.println("\nPerson "+(i+1));
            System.out.print("Weight: ");
            weight[i]=sc.nextDouble();
            System.out.print("Height: ");
            height[i]=sc.nextDouble();
            if(weight[i]<=0||height[i]<=0){
                System.out.println("Invalid input");
                i--;
            }
        }
        for(int i=0;i<n;i++){
            bmi[i]=weight[i]/(height[i]*height[i]);
            if(bmi[i]<=18.4){
                status[i]="Underweight";
            }
            else if(bmi[i]>=18.5&&bmi[i]<=24.9){
                status[i]="Normal";
            }
            else if(bmi[i]>=25.0&&bmi[i]<=39.9){
                status[i]="Overweight";
            }
            else{
                status[i]="Obese";
            }
        }
        for(int i=0;i<n;i++){
            System.out.println("Person "+(i+1));
            System.out.println("Height: "+height[i]+" m");
            System.out.println("Weight: "+weight[i]+" kg");
            System.out.println("BMI: "+bmi[i]);
            System.out.println("Status: "+status[i]+"\n");
        }
    }
}
