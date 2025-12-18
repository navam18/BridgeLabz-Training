import java.util.Scanner;
class SquareSide{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double perimeter=sc.nextInt();
        double side=perimeter/4.0;
        System.out.println("The length of the side is "+side+" whose perimeter is "+perimeter);
    }
}