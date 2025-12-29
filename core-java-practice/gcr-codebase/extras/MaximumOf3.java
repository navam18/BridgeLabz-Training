import java.util.Scanner;

class MaximumOf3 {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        int a=getInput();
        int b=getInput();
        int c=getInput();

        int max=findMax(a,b,c);
        System.out.println("Maximum value is "+max);
    }

    static int getInput(){
        System.out.println("Enter number:");
        return sc.nextInt();
    }

    static int findMax(int a,int b,int c){
        int max=a;
        if(b>max){
            max=b;
        }
        if(c>max){
            max=c;
        }
        return max;
    }
}
