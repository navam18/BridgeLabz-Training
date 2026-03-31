import java.util.Scanner;
class HandShakes{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int students=sc.nextInt();
        int combinations=(students*(students-1))/2;
        System.out.println("Possible HandShakes is "+combinations);
    }
}