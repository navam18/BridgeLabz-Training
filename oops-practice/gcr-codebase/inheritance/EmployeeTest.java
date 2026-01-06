class Employee {
    String name;
    int id;
    double salary;

    void displayDetails() {
        System.out.println(name + " | ID: " + id + " | Salary: " + salary);
    }
}

class Manager extends Employee {
    int teamSize;
}

class Developer extends Employee {
    String programmingLanguage;
}

class Intern extends Employee {
    int internshipDuration;
}

public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.name = "Rahul";
        manager.id = 101;
        manager.salary = 80000;
        manager.teamSize = 5;

        Developer developer = new Developer();
        developer.name = "Anita";
        developer.id = 102;
        developer.salary = 60000;
        developer.programmingLanguage = "Java";

        Intern intern = new Intern();
        intern.name = "Aman";
        intern.id = 103;
        intern.salary = 15000;
        intern.internshipDuration = 6;

        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
}
