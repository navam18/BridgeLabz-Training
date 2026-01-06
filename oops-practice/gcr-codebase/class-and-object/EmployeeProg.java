public class EmployeeProg {
    String name;
    int id;
    double salary;

    void displayDetails() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        EmployeeProg e = new EmployeeProg();
        e.name = "Rohan";
        e.id = 1;
        e.salary = 500000;

        e.displayDetails();
    }
}
