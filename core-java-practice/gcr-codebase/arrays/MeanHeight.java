import java.util.Scanner;

public class MeanHeight {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        double[] height=new double[11];
        double sum=0;
        
        for(int i=0;i<11;i++){
            height[i]=sc.nextDouble();
            sum+=height[i];
        }
        
        System.out.println(sum/11);
}    
}
