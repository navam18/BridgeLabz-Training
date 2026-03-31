import java.util.Scanner;
class IllegalArgumentDemo{
    static void generateException(String s){
        System.out.println(s.substring(5,2));
    }
    static void handleException(String s){
        try{
            System.out.println(s.substring(5,2));
        }catch(IllegalArgumentException e){
            System.out.println("IllegalArgumentException handled");
        }catch(RuntimeException e){
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String s=sc.next();
        try{
            generateException(s);
        }catch(IllegalArgumentException e){
            System.out.println("Exception generated");
        }
        handleException(s);
    }
}
