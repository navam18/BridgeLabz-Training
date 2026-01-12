import java.util.*;

interface IPayable{
    double calculateBill();
}

abstract class Patient implements IPayable{
    private int id;
    private String name;
    private int age;
    public Patient(int id,String name,int age){
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public abstract void displayInfo();
}

class InPatient extends Patient{
    private int days;
    public InPatient(int id,String name,int age,int days){
        super(id,name,age);
        this.days=days;
    }
    public double calculateBill(){
        return days*1000;
    }
    public void displayInfo(){
        System.out.println("InPatient ID:"+getId()+" Name:"+getName()+" Bill:"+calculateBill());
    }
}

class OutPatient extends Patient{
    public OutPatient(int id,String name,int age){
        super(id,name,age);
    }
    public double calculateBill(){
        return 500;
    }
    public void displayInfo(){
        System.out.println("OutPatient ID:"+getId()+" Name:"+getName()+" Bill:"+calculateBill());
    }
}

public class HospitalSystem{
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Patient> list=new ArrayList<>();

    public static void main(String[] args){
        while(true){
            System.out.println("1.Add 2.View 3.Update 4.Delete 5.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                addPatient();
            }
            else if(ch==2){
                for(Patient p:list){
                    p.displayInfo();
                }
            }
            else if(ch==3){
                System.out.println("Enter id");
                int id=sc.nextInt();
                for(Patient p:list){
                    if(p.getId()==id){
                        p.setName(sc.next());
                        p.setAge(sc.nextInt());
                    }
                }
            }
            else if(ch==4){
                System.out.println("Enter id");
                int id=sc.nextInt();
                list.removeIf(p->p.getId()==id);
            }
            else{
                break;
            }
        }
    }

    static void addPatient(){
        System.out.println("Enter id name age type(1.In 2.Out)");
        int id=sc.nextInt();
        String name=sc.next();
        int age=sc.nextInt();
        int type=sc.nextInt();
        if(type==1){
            int days=sc.nextInt();
            list.add(new InPatient(id,name,age,days));
        }
        else{
            list.add(new OutPatient(id,name,age));
        }
    }
}
