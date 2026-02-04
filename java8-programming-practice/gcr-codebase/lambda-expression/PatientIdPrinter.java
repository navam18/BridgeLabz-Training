import java.util.*;

public class PatientIdPrinter{
    public static void main(String[] args){
        List<Integer> ids=List.of(101,102,103);
        ids.forEach(System.out::println);
    }
}
