import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class DateFormat{
    static void run(){
        LocalDate date=LocalDate.now();
        System.out.println(date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        System.out.println(date.format(DateTimeFormatter.ofPattern("EEE,MMM dd,yyyy")));
    }

    public static void main(String[] args){
        run();
    }
}
