import java.util.Scanner;

class FestivalLuckyDraw {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of visitors:");
        int visitors=sc.nextInt();

        int i=1;
        while(i<=visitors){
            System.out.println("Visitor "+i+" draw a number:");
            int num=sc.nextInt();

            if(num<=0){
                System.out.println("Invalid input, try again");
                continue;
            }

            if(num%3==0 && num%5==0){
                System.out.println("Congratulations! You won a gift 🎁");
            }
            else{
                System.out.println("Better luck next time");
            }

            i++;
        }
    }
}
