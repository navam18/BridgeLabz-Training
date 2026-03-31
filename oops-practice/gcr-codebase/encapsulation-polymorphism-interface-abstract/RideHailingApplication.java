import java.util.ArrayList;

abstract class Vehicle{
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;
    public Vehicle(String vehicleId,String driverName,double ratePerKm){
        this.vehicleId=vehicleId;
        this.driverName=driverName;
        this.ratePerKm=ratePerKm;
    }
    public String getVehicleId(){
        return vehicleId;
    }
    public String getDriverName(){
        return driverName;
    }
    protected double getRatePerKm(){
        return ratePerKm;
    }
    protected void setCurrentLocation(String location){
        this.currentLocation=location;
    }
    protected String getCurrentLocationValue(){
        return currentLocation;
    }
    public abstract double calculateFare(double distance);
    public void getVehicleDetails(){
        System.out.println("VehicleId:"+vehicleId+" Driver:"+driverName+" Location:"+currentLocation);
    }
}

interface GPS{
    String getCurrentLocation();
    void updateLocation(String location);
}

class Car extends Vehicle implements GPS{
    public Car(String vehicleId,String driverName,double ratePerKm){
        super(vehicleId,driverName,ratePerKm);
    }
    public double calculateFare(double distance){
        return getRatePerKm()*distance;
    }
    public String getCurrentLocation(){
        return getCurrentLocationValue();
    }
    public void updateLocation(String location){
        setCurrentLocation(location);
    }
}

class Bike extends Vehicle implements GPS{
    public Bike(String vehicleId,String driverName,double ratePerKm){
        super(vehicleId,driverName,ratePerKm);
    }
    public double calculateFare(double distance){
        return getRatePerKm()*distance*0.8;
    }
    public String getCurrentLocation(){
        return getCurrentLocationValue();
    }
    public void updateLocation(String location){
        setCurrentLocation(location);
    }
}

class Auto extends Vehicle implements GPS{
    public Auto(String vehicleId,String driverName,double ratePerKm){
        super(vehicleId,driverName,ratePerKm);
    }
    public double calculateFare(double distance){
        return getRatePerKm()*distance*0.9;
    }
    public String getCurrentLocation(){
        return getCurrentLocationValue();
    }
    public void updateLocation(String location){
        setCurrentLocation(location);
    }
}

public class RideHailingApplication{
    public static void main(String[] args){
        ArrayList<Vehicle> vehicles=new ArrayList<>();
        Car c1=new Car("C101","Amit",15);
        Bike b1=new Bike("B201","Riya",10);
        Auto a1=new Auto("A301","Sohan",12);
        c1.updateLocation("Sector 18");
        b1.updateLocation("Railway Station");
        a1.updateLocation("City Mall");
        vehicles.add(c1);
        vehicles.add(b1);
        vehicles.add(a1);
        calculateFares(vehicles,10);
    }
    public static void calculateFares(ArrayList<Vehicle> vehicles,double distance){
        for(Vehicle v:vehicles){
            v.getVehicleDetails();
            System.out.println("Fare:"+v.calculateFare(distance));
        }
    }
}
