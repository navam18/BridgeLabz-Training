import java.util.Scanner;
public class Factors { 
    static int[] findFactors(int number){ 
        int count=0; 
        for (int i=1;i<=number;i++) { 
            if (number%i==0) {
                count++; 
            }
            }
            int[] factors=new int[count];
            int index=0;
            for(int i=1;i<=number;i++){
                if(number%i==0){
                    factors[index++]=i;
                } 
            }
            return factors;
        } 
        static int getSum(int[] factors){
            int sum=0;
            for(int value:factors){
                sum+=value; 
            } return sum;
        } 
        static long getProduct(int[] factors){
            long product=1;
            for(int value:factors){
                product*=value; 
            }
            return product;
        } 
        static double getSumOfSquares(int[] factors){
            double sum=0;
            for(int value:factors){
                sum += Math.pow(value, 2);
            }
            return sum;
        } 
        public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            int number=sc.nextInt(); 
            int[] factors = findFactors(number); 
            for(int value:factors){ 
                System.out.print(value + " "); 
            } 
            System.out.println(); 
            System.out.println(getSum(factors)); 
            System.out.println(getProduct(factors)); 
            System.out.println(getSumOfSquares(factors)); 
        } 
    }