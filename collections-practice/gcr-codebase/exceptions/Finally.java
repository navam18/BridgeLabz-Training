package exceptions;
import java.util.Scanner;
class Finally{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        try{
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=a/b;
            System.out.println(c);
        }
        catch(ArithmeticException e){
            System.out.println("Division by zero  is not allowed");
        }
        finally{
            System.out.println("Operation completed");
        }
    }
}