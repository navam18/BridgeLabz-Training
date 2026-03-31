import java.util.*;

abstract class Vehicle{
    String number;

    Vehicle(String number){
        this.number=number;
    }
}

class Car extends Vehicle{
    Car(String n){
        super(n);
    }
}

class Bike extends Vehicle{
    Bike(String n){
        super(n);
    }
}

class ParkingSlot{
    int id;
    boolean free=true;

    ParkingSlot(int id){
        this.id=id;
    }
}

class NoParkingSlotAvailableException extends Exception{
    NoParkingSlotAvailableException(String msg){
        super(msg);
    }
}

public class SmartParking{

    Map<Integer,ParkingSlot> slots=new TreeMap<>();
    Queue<Vehicle> waiting=new LinkedList<>();

    SmartParking(){
        slots.put(1,new ParkingSlot(1));
        slots.put(2,new ParkingSlot(2));
        slots.put(3,new ParkingSlot(3));
    }

    void park(Vehicle v) throws NoParkingSlotAvailableException{

        for(ParkingSlot s:slots.values()){
            if(s.free){
                s.free=false;
                System.out.println(v.number+" parked in slot "+s.id);
                return;
            }
        }

        waiting.add(v);
        throw new NoParkingSlotAvailableException("No Parking Slot Available");
    }

    public static void main(String args[]){

        SmartParking sp=new SmartParking();

        try{
            sp.park(new Car("CAR1"));
            sp.park(new Bike("BIKE1"));
            sp.park(new Car("CAR2"));
            sp.park(new Bike("BIKE2"));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
