import java.util.*;

interface IRentable{
    double calculateRent(int days);
}

abstract class Vehicle implements IRentable{
    protected int id;
    protected String brand;
    protected double rate;
    public Vehicle(int id,String brand,double rate){
        this.id=id;
        this.brand=brand;
        this.rate=rate;
    }
    public int getId(){
        return id;
    }
}

class Bike extends Vehicle{
    public Bike(int id,String brand,double rate){
        super(id,brand,rate);
    }
    public double calculateRent(int days){
        return days*rate;
    }
}

class Car extends Vehicle{
    public Car(int id,String brand,double rate){
        super(id,brand,rate);
    }
    public double calculateRent(int days){
        return days*rate*1.5;
    }
}

class Truck extends Vehicle{
    public Truck(int id,String brand,double rate){
        super(id,brand,rate);
    }
    public double calculateRent(int days){
        return days*rate*2;
    }
}

class Customer{
    private int id;
    private String name;
    public Customer(int id,String name){
        this.id=id;
        this.name=name;
    }
}

public class VehicleRentalApp{
    static Scanner sc=new Scanner(System.in);
    static ArrayList<Vehicle> list=new ArrayList<>();

    public static void main(String[] args){
        while(true){
            System.out.println("1.Add 2.View 3.Update 4.Delete 5.Rent 6.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                add();
            }
            else if(ch==2){
                for(Vehicle v:list){
                    System.out.println(v.id+" "+v.brand+" "+v.rate);
                }
            }
            else if(ch==3){
                int id=sc.nextInt();
                double r=sc.nextDouble();
                for(Vehicle v:list){
                    if(v.id==id){
                        v.rate=r;
                    }
                }
            }
            else if(ch==4){
                int id=sc.nextInt();
                list.removeIf(v->v.id==id);
            }
            else if(ch==5){
                int id=sc.nextInt();
                int d=sc.nextInt();
                for(Vehicle v:list){
                    if(v.id==id){
                        System.out.println(v.calculateRent(d));
                    }
                }
            }
            else{
                break;
            }
        }
    }

    static void add(){
        int id=sc.nextInt();
        String b=sc.next();
        double r=sc.nextDouble();
        int t=sc.nextInt();
        if(t==1){
            list.add(new Bike(id,b,r));
        }
        else if(t==2){
            list.add(new Car(id,b,r));
        }
        else{
            list.add(new Truck(id,b,r));
        }
    }
}
