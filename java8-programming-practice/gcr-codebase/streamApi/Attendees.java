import java.util.*;
class Attendees {
    public static void main(String[] args) {
        List<String> attendees = Arrays.asList(
            "Amit",
            "Neha",
            "Rahul",
            "Sneha",
            "Karan"
        );
        attendees.stream()
                  .forEach(name ->System.out.println("Welcome to the event, " + name + "!"));
    }
}