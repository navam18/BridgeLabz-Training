import java.util.Scanner;

public class RandomNumber {

    static int[] generate4DigitRandomArray(int size){
        int[] num=new int[size];
        for(int i=0;i<size;i++){
            num[i]=(int)(Math.random()*9000)+1000;
        }
        return num;
    }

    static double[] findAverageMinMax(int[] num){
        int sum=0;
        int min=num[0];
        int max=num[0];

        for(int i=0;i<num.length;i++){
            sum+=num[i];
            min=Math.min(min,num[i]);
            max=Math.max(max,num[i]);
        }

        double avg=(double)sum/num.length;
        return new double[]{avg,min,max};
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        int[] num=generate4DigitRandomArray(5);

        for(int value:num){
            System.out.println(value);
        }

        double[] result=findAverageMinMax(num);

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
}
