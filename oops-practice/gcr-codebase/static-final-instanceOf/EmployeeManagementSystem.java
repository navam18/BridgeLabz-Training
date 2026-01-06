
class EmployeeManagementSystem {

    // Static variables
    static String companyName = "Tech Solutions Inc.";
    static int totalEmployees = 0;

    // Instance variables
    final int id;   // final
    String name;
    String designation;

    // Constructor using this
    EmployeeManagementSystem(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    // Static method
    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayDetails(Object obj) {
        if (obj instanceof EmployeeManagementSystem) {
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Designation: " + designation);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem e1 = new EmployeeManagementSystem(101, "Thamarai", "Software Engineer");
        EmployeeManagementSystem e2 = new EmployeeManagementSystem(102, "Rohan", "Project Manager");

        EmployeeManagementSystem.displayTotalEmployees();

        e1.displayDetails(e1);
        e2.displayDetails(e2);
    }
}

