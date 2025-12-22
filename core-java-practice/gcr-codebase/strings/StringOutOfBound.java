import java.util.Scanner;

class StringOutOfBound{
    static void generateException(String s){
        System.out.println(s.charAt(s.length()));
    }
    static void handleException(String s){
        try{
            System.out.println(s.charAt(s.length()));
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("StringIndexOutOfBoundsException handled");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String s=sc.next();
        try{
            generateException(s);
        }catch(StringIndexOutOfBoundsException e){
            System.out.println("Exception generated");
        }
        handleException(s);
    }
}
