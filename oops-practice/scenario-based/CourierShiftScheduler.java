import java.util.*;

class Employee{
    String name;

    Employee(String name){
        this.name=name;
    }
}

class ShiftAlreadyAssignedException extends Exception{
    ShiftAlreadyAssignedException(String msg){
        super(msg);
    }
}

public class CourierShiftScheduler{

    List<Employee> staff=new ArrayList<>();
    Map<String,List<Employee>> shifts=new HashMap<>();

    void addEmployee(Employee e){
        staff.add(e);
    }

    void assignShift(String shift,Employee e) throws ShiftAlreadyAssignedException{

        shifts.putIfAbsent(shift,new ArrayList<>());

        if(shifts.get(shift).contains(e)){
            throw new ShiftAlreadyAssignedException("Employee already assigned to this shift");
        }

        shifts.get(shift).add(e);
        System.out.println(e.name+" assigned to "+shift);
    }

    public static void main(String args[]){

        CourierShiftScheduler c=new CourierShiftScheduler();

        Employee e1=new Employee("Amit");
        Employee e2=new Employee("Rahul");

        c.addEmployee(e1);
        c.addEmployee(e2);

        try{
            c.assignShift("Morning",e1);
            c.assignShift("Morning",e2);
            c.assignShift("Morning",e1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
