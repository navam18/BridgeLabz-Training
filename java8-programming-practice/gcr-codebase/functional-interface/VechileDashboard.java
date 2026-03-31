interface Vehicle{
    void displaySpeed();
    default void displayBattery(){
        System.out.println("Battery feature not supported");
    }
}

class Car implements Vehicle{

    public void displaySpeed(){
        System.out.println("Speed: 80 km/h");
    }
}

class ElectricCar implements Vehicle{

    public void displaySpeed(){
        System.out.println("Speed: 60 km/h");
    }

    public void displayBattery(){
        System.out.println("Battery: 75%");
    }
}

class VehicleDashboard{
    public static void main(String[] args){

        Vehicle v1=new Car();
        Vehicle v2=new ElectricCar();

        v1.displayBattery();
        v2.displayBattery();
    }
}
