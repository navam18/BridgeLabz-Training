import java.util.*;
import java.time.*;
import java.time.format.*;
class LoggingTransaction {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN1001",
            "TXN1002",
            "TXN1003",
            "TXN1004"
        );
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        transactionIds.stream()
                      .forEach(txn ->
                          System.out.println(
                              "Transaction " + txn +
                              " logged at " +
                              LocalDateTime.now().format(formatter)
                          )
                      );
    }
}