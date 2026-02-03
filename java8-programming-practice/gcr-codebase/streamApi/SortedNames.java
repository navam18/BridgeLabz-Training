import java.util.*;
class SortedNames {
    public static void main(String[] args) {
        List<String> customers = Arrays.asList(
            "navam",
            "amit",
            "rahul",
            "sneha",
            "karan"
        );
        customers.stream()
                 .map(name -> name.toUpperCase())  // map
                 .sorted()                          // sorted
                 .forEach(System.out::println);
    }
}