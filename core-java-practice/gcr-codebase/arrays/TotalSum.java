import java.util.Scanner;

public class TotalSum {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        double[]arr=new double[10];
        double total_sum=0;
        int idx=0;

        while(true){
            double n=sc.nextDouble();

            if(n<=0||idx==10)break;
            arr[idx]=n;
            idx++;
        }

        for(int j=0;j<idx;j++){
            total_sum+=arr[j];
        }

        System.out.println(total_sum);
    }    
}
