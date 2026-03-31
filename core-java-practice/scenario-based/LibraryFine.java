import java.util.Scanner;

class LibraryFine{
    static void run(Scanner sc){
        for(int i=1;i<=5;i++){
            int due=sc.nextInt();
            int returned=sc.nextInt();
            if(returned>due){
                System.out.println((returned-due)*5);
            }else{
                System.out.println(0);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        run(sc);
    }
}
