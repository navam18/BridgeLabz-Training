import java.util.ArrayList;

abstract class Employee{
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;
    public Employee(int employeeId,String name,double baseSalary){
        this.employeeId=employeeId;
        this.name=name;
        this.baseSalary=baseSalary;
    }
    public int getEmployeeId(){
        return employeeId;
    }
    public void setEmployeeId(int employeeId){
        this.employeeId=employeeId;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getBaseSalary(){
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary){
        this.baseSalary=baseSalary;
    }
    public void setDepartment(String department){
        this.department=department;
    }
    public String getDepartment(){
        return department;
    }
    public abstract double calculateSalary();
    public void displayDetails(){
        System.out.println("Id:"+employeeId+" Name:"+name+" Department:"+department+" Salary:"+calculateSalary());
    }
}

interface Department{
    void assignDepartment(String department);
    String getDepartmentDetails();
}

class FullTimeEmployee extends Employee implements Department{
    public FullTimeEmployee(int employeeId,String name,double baseSalary){
        super(employeeId,name,baseSalary);
    }
    public double calculateSalary(){
        return getBaseSalary();
    }
    public void assignDepartment(String department){
        setDepartment(department);
    }
    public String getDepartmentDetails(){
        return getDepartment();
    }
}

class PartTimeEmployee extends Employee implements Department{
    private int workHours;
    private double hourlyRate;
    public PartTimeEmployee(int employeeId,String name,int workHours,double hourlyRate){
        super(employeeId,name,0);
        this.workHours=workHours;
        this.hourlyRate=hourlyRate;
    }
    public int getWorkHours(){
        return workHours;
    }
    public void setWorkHours(int workHours){
        this.workHours=workHours;
    }
    public double getHourlyRate(){
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate){
        this.hourlyRate=hourlyRate;
    }
    public double calculateSalary(){
        return workHours*hourlyRate;
    }
    public void assignDepartment(String department){
        setDepartment(department);
    }
    public String getDepartmentDetails(){
        return getDepartment();
    }
}

public class EmployeeManagementSystem{
    public static void main(String[] args){
        ArrayList<Employee> employees=new ArrayList<>();
        FullTimeEmployee e1=new FullTimeEmployee(101,"Amit",50000);
        PartTimeEmployee e2=new PartTimeEmployee(102,"Riya",80,300);
        e1.assignDepartment("IT");
        e2.assignDepartment("HR");
        employees.add(e1);
        employees.add(e2);
        for(Employee e:employees){
            e.displayDetails();
        }
    }
}
