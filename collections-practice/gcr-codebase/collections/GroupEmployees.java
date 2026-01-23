import java.util.*;

class Employeee {
    String name;
    String department;

    Employeee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupEmployees {

    public static Map<String, List<Employeee>> groupByDepartment(
            List<Employeee> employees) {

        Map<String, List<Employeee>> map = new HashMap<>();

        for (Employeee emp : employees) {
            map.computeIfAbsent(emp.department, k -> new ArrayList<>())
                    .add(emp);
        }

        return map;
    }

    public static void main(String[] args) {

        List<Employeee> employees = List.of(
                new Employeee("Alice", "HR"),
                new Employeee("Bob", "IT"),
                new Employeee("Carol", "HR")
        );

        System.out.println(groupByDepartment(employees));
    }
}