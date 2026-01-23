import java.util.*;
import java.time.LocalDate;

class Policy {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;

    Policy(String policyNumber, String holderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return policyNumber + " | " + holderName + " | " + expiryDate;
    }
}

public class PolicyManagerHashMap {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> insertionOrderMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> expirySortedMap = new TreeMap<>();

    // Add policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderMap.put(policy.policyNumber, policy);

        expirySortedMap
                .computeIfAbsent(policy.expiryDate, k -> new ArrayList<>())
                .add(policy);
    }

    // Retrieve by policy number
    public Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Policies expiring in next 30 days
    public List<Policy> expiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate next30 = today.plusDays(30);

        List<Policy> result = new ArrayList<>();
        expirySortedMap.subMap(today, true, next30, true)
                .values()
                .forEach(result::addAll);
        return result;
    }

    // Policies by holder
    public List<Policy> byHolder(String holder) {
        List<Policy> list = new ArrayList<>();
        for (Policy p : policyMap.values()) {
            if (p.holderName.equalsIgnoreCase(holder)) {
                list.add(p);
            }
        }
        return list;
    }

    // Remove expired policies
    public void removeExpired() {
        LocalDate today = LocalDate.now();

        Iterator<Map.Entry<String, Policy>> it = policyMap.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getValue().expiryDate.isBefore(today)) {
                it.remove();
            }
        }
    }
    public static void main(String[] args) {

        PolicyManagerHashMap manager = new PolicyManagerHashMap();

        manager.addPolicy(new Policy("P101", "Alice",
                LocalDate.now().plusDays(10)));
        manager.addPolicy(new Policy("P102", "Bob",
                LocalDate.now().plusDays(40)));
        manager.addPolicy(new Policy("P103", "Alice",
                LocalDate.now().minusDays(2)));

        System.out.println("Retrieve Policy P101:");
        System.out.println(manager.getPolicy("P101"));

        System.out.println("\nPolicies expiring in next 30 days:");
        System.out.println(manager.expiringSoon());

        System.out.println("\nPolicies for Alice:");
        System.out.println(manager.byHolder("Alice"));

        manager.removeExpired();
        System.out.println("\nAfter removing expired policies:");
        System.out.println(manager.policyMap.values());
    }
}
