import java.util.Scanner;
class  WhileLoopDecrementBy1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter countdown start value: ");
        int count = sc.nextInt();
        while (count >= 1) {
            System.out.println(count);
            count--;
        }
    }
}
