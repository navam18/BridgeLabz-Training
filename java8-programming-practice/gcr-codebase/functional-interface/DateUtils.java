import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

interface Date {

    static String formatDate(LocalDate date){

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        return date.format(formatter);
    }
}

class DateUtils{
    public static void main(String[] args){

        LocalDate today = LocalDate.now();

        System.out.println(Date.formatDate(today));
    }
}
