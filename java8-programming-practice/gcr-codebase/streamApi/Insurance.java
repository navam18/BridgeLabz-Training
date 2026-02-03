import java.util.*;
import java.util.stream.*;
class InsuranceClaim     {
    String claimType;
    double claimAmount;
    InsuranceClaim(String claimType, double claimAmount) {
        this.claimType = claimType;
        this.claimAmount = claimAmount;
    }
}
class Main {
    public static void main(String[] args) {
        List<InsuranceClaim> claims = Arrays.asList(
            new InsuranceClaim("Health", 50000),
            new InsuranceClaim("Vehicle", 20000),
            new InsuranceClaim("Health", 30000),
            new InsuranceClaim("Life", 100000),
            new InsuranceClaim("Vehicle", 40000),
            new InsuranceClaim("Health", 70000)
        );
        Map<String, Double> averageClaimAmount =
            claims.stream()
                  .collect(Collectors.groupingBy(
                      c -> c.claimType,
                      Collectors.averagingDouble(c -> c.claimAmount)
                  ));
        averageClaimAmount.forEach((type, avg) ->
            System.out.println(type + " Average Claim Amount: " + avg)
        );
    }
}