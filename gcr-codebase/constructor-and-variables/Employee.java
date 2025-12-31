class Employee{
    public int employeeID;
    protected String department;
    private double salary;

    Employee(int employeeID,String department,double salary){
        this.employeeID=employeeID;
        this.department=department;
        this.salary=salary;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary=salary;
    }
}

class Manager extends Employee{
    Manager(int employeeID,String department,double salary){
        super(employeeID,department,salary);
    }

    void displayDetails(){
        System.out.println(employeeID+" "+department);
    }

    public static void main(String[] args){
        Manager m1=new Manager(1,"IT",80000);
        m1.displayDetails();
        m1.setSalary(90000);
        System.out.println(m1.getSalary());
    }
}
