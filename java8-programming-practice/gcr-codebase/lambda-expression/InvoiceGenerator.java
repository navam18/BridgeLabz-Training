import java.util.*;
import java.util.function.Function;

class Invoice{
    int id;
    Invoice(int id){
        this.id=id;
    }
    public String toString(){
        return "Invoice:"+id;
    }
}

public class InvoiceGenerator{
    public static void main(String[] args){
        List<Integer> ids=List.of(1,2,3);
        Function<Integer,Invoice> f=Invoice::new;
        ids.stream().map(f).forEach(System.out::println);
    }
}
