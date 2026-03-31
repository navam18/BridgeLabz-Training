import java.util.Scanner;
class Calculator{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int n2=sc.nextInt();
        int add=n1+n2;
        int subtract=n1-n2;
        int product=n1*n2;
        double divison=(double)n1/n2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+n1+" and "+n2+" is "+add+","+subtract+","+product+",and "+divison);
    }
}