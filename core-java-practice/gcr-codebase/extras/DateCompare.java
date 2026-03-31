import java.time.LocalDate;
import java.util.Scanner;

class DateCompare{
    static void run(Scanner sc){
        LocalDate d1=LocalDate.parse(sc.next());
        LocalDate d2=LocalDate.parse(sc.next());
        if(d1.isBefore(d2))System.out.println("Before");
        else if(d1.isAfter(d2))System.out.println("After");
        else System.out.println("Equal");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        run(sc);
    }
}
