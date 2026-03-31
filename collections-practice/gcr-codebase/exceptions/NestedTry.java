package exceptions;
import java.util.Scanner;
class NestedTry{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[5];
        for(int x=0;x<5;x++){
            arr[x]=sc.nextInt();
        }
        int index=sc.nextInt();
        int divisor=sc.nextInt();
        try{
            int value=arr[index];
            try{
                int result=value/divisor;
                System.out.println("Result:"+result);
            }
            catch(ArithmeticException e){
                System.out.println("Cannot divide by zero!");
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid array index!");
        }   
    }
}