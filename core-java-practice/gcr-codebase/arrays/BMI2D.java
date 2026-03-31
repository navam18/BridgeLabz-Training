import java.util.Scanner;
class BMI2D{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Number of persons: ");
        int num=sc.nextInt();
        double[][] personData=new double[num][3];
        String[] weightStatus=new String[num];
        for(int i=0;i<num;i++){
            System.out.println("\nPerson "+(i+1));
            System.out.print("Weight: ");
            personData[i][0]=sc.nextDouble();
            System.out.print("Height: ");
            personData[i][1]=sc.nextDouble();
            if(personData[i][0]<=0||personData[i][1]<=0){
                System.out.println("Invalid input\n");
                i--;
            }
        }
        for(int i=0;i<num;i++){
            personData[i][2]=personData[i][0]/(personData[i][1]*personData[i][1]);
            if(personData[i][2]<=18.4){
                weightStatus[i]="Underweight";
            }else if(personData[i][2]>=18.5&&personData[i][2]<=24.9){
                weightStatus[i]="Normal";
            }else if(personData[i][2]>=25.0&&personData[i][2]<=39.9){
                weightStatus[i]="Overweight";
            }else{
                weightStatus[i]="Obese";
            }
        }
        for(int i=0;i<num;i++){
            System.out.println("Person "+(i+1));
            System.out.println("Weight: "+personData[i][0]+" kg");
            System.out.println("Height: "+personData[i][1]+" m");
            System.out.println("BMI: "+personData[i][2]);
            System.out.println("Status: "+weightStatus[i]+"\n");
        }
    }
}
