import java.util.Scanner;

class MovieBooking{
    static void run(Scanner sc){
        for(int i=1;i<=3;i++){
            String movie=sc.next();
            String seat=sc.next();
            boolean snacks=sc.nextBoolean();
            int price=0;
            switch(movie){
                case "action":price=200;break;
                case "comedy":price=180;break;
                default:price=150;
            }
            if(seat.equals("gold"))price+=100;
            else price+=50;
            if(snacks)price+=80;
            System.out.println(price);
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        run(sc);
    }
}
