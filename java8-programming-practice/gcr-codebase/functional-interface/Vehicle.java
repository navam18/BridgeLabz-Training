interface AllVehicle{
    void rent();
    void returnVehicle();
}
class Car implements AllVehicle{
    public void rent(){
        System.out.println("Car rented");
    }
    public void returnVehicle(){
        System.out.println("Car returned");
    } 
}
class Bike implements AllVehicle{
    public void rent(){
        System.out.println("Bike rented");
    }
    public void returnVehicle(){
        System.out.println("Bike returned");
    }
}   
class Bus  implements AllVehicle{
    public void  rent(){
        System.out.println("Bus rented");
    }
    public void returnVehicle(){
        System.out.println("Bus returned");
    }
}
class Vehicle{
    public static void main(String[] args){
        AllVehicle v1=new Car();
        AllVehicle v2=new Bike();
        AllVehicle v3=new Bus();
        v1.rent();
        v2.rent();
        v3.rent();
    } 
}