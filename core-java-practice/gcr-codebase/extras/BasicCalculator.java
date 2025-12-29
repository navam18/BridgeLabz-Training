import java.util.Scanner;

class BasicCalculator {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int choice=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();

        if(choice==1){
            System.out.println(add(a,b));
        }
        else if(choice==2){
            System.out.println(subtract(a,b));
        }
        else if(choice==3){
            System.out.println(multiply(a,b));
        }
        else if(choice==4){
            System.out.println(divide(a,b));
        }
    }

    static int add(int a,int b){
        return a+b;
    }

    static int subtract(int a,int b){
        return a-b;
    }

    static int multiply(int a,int b){
        return a*b;
    }

    static int divide(int a,int b){
        return a/b;
    }
}
