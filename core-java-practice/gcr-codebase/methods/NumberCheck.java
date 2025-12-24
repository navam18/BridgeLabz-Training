import java.util.Scanner;

public class NumberCheck {

    static boolean isPositive(int number){
        if(number>=0){
            return true;
        }
        return false;
    }

    static boolean isEven(int number){
        if(number%2==0){
            return true;
        }
        return false;
    }

    static int compare(int number1,int number2){
        if(number1>number2){
            return 1;
        }else if(number1==number2){
            return 0;
        }else{
            return -1;
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] numbers=new int[5];

        for(int i=0;i<numbers.length;i++){
            numbers[i]=sc.nextInt();
        }

        for(int i=0;i<numbers.length;i++){
            if(isPositive(numbers[i])){
                if(isEven(numbers[i])){
                    System.out.println("Positive Even");
                }else{
                    System.out.println("Positive Odd");
                }
            }else{
                System.out.println("Negative");
            }
        }

        int result=compare(numbers[0],numbers[4]);
        if(result==1){
            System.out.println("First number is greater than last number");
        }else if(result==0){
            System.out.println("First number is equal to last number");
        }else{
            System.out.println("First number is less than last number");
        }
    }
}
