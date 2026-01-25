package exceptions;
import java.util.Scanner;
class CustomException extends Exception{
    public CustomException(int age){
        super("Invalid age:"+age);
    }
}

class AgeValidator{
    public static void validAge(int age)throws CustomException{
        if(age<18){
            throw new CustomException(age);
        }
        System.out.println("Valid age:"+age);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int age=sc.nextInt();
        try{
            validAge(age);
        }
        catch(CustomException e){
            System.out.println(e);
        }
    }
}
