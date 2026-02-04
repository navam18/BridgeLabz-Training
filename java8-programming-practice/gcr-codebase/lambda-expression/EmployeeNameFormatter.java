import java.util.*;

public class EmployeeNameFormatter{
    public static void main(String[] args){
        List<String> names=List.of("aryan","rahul","neha");
        names.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
