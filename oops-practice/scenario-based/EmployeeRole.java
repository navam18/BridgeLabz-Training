abstract class Employee{
    private final String name;
    private final double salary;
    public Employee(String name,double salary){
        this.name=name;
        this.salary=salary;
    }
    public double getSalary(){
        return salary;
    }
    public abstract double getBonus();
}

class Manager extends Employee{
    private final double bonus;
    public Manager(String name,double salary){
        super(name,salary);
        bonus=salary*0.10;
    }
    public double getBonus(){
        return bonus;
    }
}

class Developer extends Employee{
    private final double bonus;
    public Developer(String name,double salary){
        super(name,salary);
        bonus=salary>50000?salary*0.05:0.0;
    }
    public double getBonus(){
        return bonus;
    }
}

class MainEmployee{
    public static void main(String[] args){
        Employee manager=new Manager("Alice",80000);
        System.out.printf("%.2f%n",manager.getBonus());
        Employee developer1=new Developer("Bob",60000);
        System.out.printf("%.2f%n",developer1.getBonus());
        Employee developer2=new Developer("Charlie",40000);
        System.out.printf("%.2f%n",developer2.getBonus());
    }
}