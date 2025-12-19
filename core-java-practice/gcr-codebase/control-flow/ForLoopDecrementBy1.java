import java.util.Scanner;
class ForLoopDecrementBy1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        for (int x=count;x>=1;x--) {
            System.out.println(x);
        }
    }
}