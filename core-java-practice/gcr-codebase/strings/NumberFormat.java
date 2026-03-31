import java.util.Scanner;

class NumberFormat{
    static void generateException(String text){
        System.out.println(Integer.parseInt(text));
    }
    static void handleException(String text){
        try{
            System.out.println(Integer.parseInt(text));
        }catch(NumberFormatException e){
            System.out.println("NumberFormatException handled");
        }catch(RuntimeException e){
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String text=sc.next();
        try{
            generateException(text);
        }catch(NumberFormatException e){
            System.out.println("Exception generated");
        }
        handleException(text);
    }
}
