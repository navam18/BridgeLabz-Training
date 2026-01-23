package interfaces;


import java.time.LocalDate;
import java.util.Objects;
import java.util.*;


class Policy {
    int policyNumber;
    String holderName;
    LocalDate expiryDate;
    String coverageType;
    double premium;

    public Policy(int policyNumber, String holderName, LocalDate expiryDate, String coverageType, double premium) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premium = premium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy p = (Policy) o;
        return policyNumber == p.policyNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return policyNumber + " | " + holderName + " | " + expiryDate + " | " + coverageType + " | " + premium;
    }
}

class PolicyManager {

    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>(Comparator.comparing(p -> p.expiryDate));

    public void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    public void displayAll() {
        hashSet.forEach(System.out::println);
    }

    public void expiringSoon() {
        LocalDate now = LocalDate.now();
        treeSet.stream()
                .filter(p -> !p.expiryDate.isAfter(now.plusDays(30)))
                .forEach(System.out::println);
    }

    public void byCoverage(String type) {
        hashSet.stream()
                .filter(p -> p.coverageType.equalsIgnoreCase(type))
                .forEach(System.out::println);
    }

    public void findDuplicates(List<Policy> list) {
        Set<Integer> seen = new HashSet<>();
        list.stream()
                .filter(p -> !seen.add(p.policyNumber))
                .forEach(System.out::println);
    }

    public void performanceTest() {
        Policy temp = new Policy(9999,"Test",LocalDate.now(),"Auto",1000);

        test("HashSet", new HashSet<>(), temp);
        test("LinkedHashSet", new LinkedHashSet<>(), temp);
        test("TreeSet", new TreeSet<>(Comparator.comparing(p -> p.expiryDate)), temp);
    }

    private void test(String name, Set<Policy> set, Policy p) {
        long start = System.nanoTime();
        for(int i=0;i<100000;i++) set.add(new Policy(i,"A",LocalDate.now(),"H",100));
        set.contains(p);
        set.remove(p);
        long end = System.nanoTime();
        System.out.println(name + " Time: " + (end-start));
    }
}


public class PolicyManagementSystem {
    public static void main(String[] args) {
        System.out.println("Kapil");
    }
}
