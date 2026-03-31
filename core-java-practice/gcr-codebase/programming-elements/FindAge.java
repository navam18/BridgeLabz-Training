import java.util.Scanner;
class FindAge{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int birthYear=2000;
        int currentYear=2024;
        int age=currentYear-birthYear;
        System.out.println("Harry's age in 2024 is "+age);
    }
}