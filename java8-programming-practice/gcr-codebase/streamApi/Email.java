import java.util.*;
class Email {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList(
            "amit@gmail.com",
            "neha@gmail.com",
            "rahul@gmail.com",
            "sneha@gmail.com",
            "karan@gmail.com"
        );
        emails.stream()
              .forEach(email ->
                  System.out.println("Notification sent to: " + email)
              );
    }
}