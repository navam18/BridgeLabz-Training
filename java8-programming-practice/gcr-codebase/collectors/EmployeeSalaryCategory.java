import java.util.*;
import java.util.stream.*;

class Employee {

    String department;
    double salary;

    Employee(String department, double salary) {
        this.department = department;
        this.salary = salary;
    }

    String getDepartment() {
        return department;
    }

    double getSalary() {
        return salary;
    }
}

public class EmployeeSalaryCategory {

    public static void main(String args[]) {

        List<Employee> list = Arrays.asList(
                new Employee("IT", 50000),
                new Employee("HR", 40000),
                new Employee("IT", 60000),
                new Employee("HR", 45000),
                new Employee("Sales", 55000)
        );

        Map<String, Double> avgSalary =
                list.stream()
                    .collect(Collectors.groupingBy(
                            Employee::getDepartment,
                            Collectors.averagingDouble(Employee::getSalary)
                    ));

        System.out.println(avgSalary);
    }
}
