import java.time.LocalDate;
import java.util.Scanner;

class DateMath{
    static void run(Scanner sc){
        LocalDate date=LocalDate.parse(sc.next());
        System.out.println(date.plusDays(7).plusMonths(1).plusYears(2).minusWeeks(3));
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        run(sc);
    }
}
