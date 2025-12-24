import java.util.Scanner;

public class SumNaturalNum {

    static int getSumRecursive(int number){
        if(number==0){
            return 0;
        }
        return number + getSumRecursive(number-1);
    }

    static int getSumFormula(int number){
        return number*(number+1)/2;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();

        if(number<=0){
            System.out.println("Not a natural number");
        }else{
            int recursiveSum=getSumRecursive(number);
            int formulaSum=getSumFormula(number);

            System.out.println(recursiveSum);
            System.out.println(formulaSum);

            if(recursiveSum==formulaSum){
                System.out.println("Both results are correct");
            }else{
                System.out.println("Results are not equal");
            }
        }
    }
}
