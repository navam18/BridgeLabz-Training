import java.util.Scanner;
class Zara{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[] salary=new double[10];
        double[] serviceYears=new double[10];
        double[] bonus=new double[10];
        double[] newSalary=new double[10];
        double totalBonus=0;
        double totalOldSalary=0;
        double totalNewSalary=0;
        for(int i=0;i<10;i++){
            System.out.println("Employee "+(i+1));
            System.out.print("Salary: ");
            salary[i]=sc.nextDouble();
            System.out.print("Years of service: ");
            serviceYears[i]=sc.nextDouble();
            if(salary[i]<=0||serviceYears[i]<0){
                System.out.println("Invalid input\n");
                i--;
                continue;
            }
            totalOldSalary+=salary[i];
        }
        for(int i=0;i<10;i++){
            if(serviceYears[i]>5){
                bonus[i]=salary[i]*0.05;
            }
            else{
                bonus[i]=salary[i]*0.02;
            }
            newSalary[i]=salary[i]+bonus[i];
            totalBonus+=bonus[i];
            totalNewSalary+=newSalary[i];
        }
        System.out.println("Old salary:"+totalOldSalary);
        System.out.println("Bonus:"+totalBonus);
        System.out.println("New salary:"+totalNewSalary);
    }
}
