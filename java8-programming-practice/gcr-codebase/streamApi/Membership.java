import java.time.*;
import java.util.*;
class Membership {
    String name;
    LocalDate expiryDate;
    Membership(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
    public String toString() {
        return name + " - Expiry Date: " + expiryDate;
    }
}
class Main {
    public static void main(String[] args) {
        List<Membership> members = Arrays.asList(
            new Membership("Amit", LocalDate.now().plusDays(10)),
            new Membership("Neha", LocalDate.now().plusDays(45)),
            new Membership("Rahul", LocalDate.now().plusDays(25)),
            new Membership("Sneha", LocalDate.now().plusDays(5)),
            new Membership("Karan", LocalDate.now().plusDays(60))
        );
        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);
        members.stream()
               .filter(m -> 
                   !m.expiryDate.isBefore(today) &&
                    m.expiryDate.isBefore(next30Days)
               )
               .forEach(System.out::println);
    }
}