import java.util.*;

class InsufficientLeaveBalanceException extends Exception{
    public InsufficientLeaveBalanceException(String msg){
        super(msg);
    }
}

class Employee{
    int id;
    String name;
    int leaveBalance;

    Employee(int id,String name,int leaveBalance){
        this.id=id;
        this.name=name;
        this.leaveBalance=leaveBalance;
    }
}

class LeaveRequest{
    int empId;
    int days;

    LeaveRequest(int empId,int days){
        this.empId=empId;
        this.days=days;
    }
}

class LeaveService{

    Map<Integer,Employee> employees=new HashMap<>();
    List<LeaveRequest> requests=new ArrayList<>();

    void addEmployee(Employee e){
        employees.put(e.id,e);
    }

    void requestLeave(int empId,int days){
        requests.add(new LeaveRequest(empId,days));
    }

    void approveLeaves() throws InsufficientLeaveBalanceException{
        for(LeaveRequest lr:requests){
            Employee e=employees.get(lr.empId);

            if(e.leaveBalance<lr.days){
                throw new InsufficientLeaveBalanceException("Not enough leave for "+e.name);
            }

            e.leaveBalance-=lr.days;
            System.out.println("Leave approved for "+e.name);
        }
    }
}

public class EmployeeLeaveManagement{
    public static void main(String args[]){
        LeaveService service=new LeaveService();

        service.addEmployee(new Employee(1,"Ram",10));
        service.addEmployee(new Employee(2,"Shyam",3));

        service.requestLeave(1,5);
        service.requestLeave(2,5);

        try{
            service.approveLeaves();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
