import java.util.ArrayList;

abstract class Vehicle{
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle(String vehicleNumber,String type,double rentalRate){
        this.vehicleNumber=vehicleNumber;
        this.type=type;
        this.rentalRate=rentalRate;
    }
    public String getVehicleNumber(){
        return vehicleNumber;
    }
    public void setVehicleNumber(String vehicleNumber){
        this.vehicleNumber=vehicleNumber;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type=type;
    }
    public double getRentalRate(){
        return rentalRate;
    }
    public void setRentalRate(double rentalRate){
        this.rentalRate=rentalRate;
    }
    public abstract double calculateRentalCost(int days);
}

interface Insurable{
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable{
    private String insurancePolicyNumber;
    public Car(String vehicleNumber,double rentalRate,String insurancePolicyNumber){
        super(vehicleNumber,"Car",rentalRate);
        this.insurancePolicyNumber=insurancePolicyNumber;
    }
    public double calculateRentalCost(int days){
        return getRentalRate()*days;
    }
    public double calculateInsurance(){
        return getRentalRate()*0.10;
    }
    public String getInsuranceDetails(){
        return "Car Insurance";
    }
}

class Bike extends Vehicle implements Insurable{
    private String insurancePolicyNumber;
    public Bike(String vehicleNumber,double rentalRate,String insurancePolicyNumber){
        super(vehicleNumber,"Bike",rentalRate);
        this.insurancePolicyNumber=insurancePolicyNumber;
    }
    public double calculateRentalCost(int days){
        return getRentalRate()*days*0.8;
    }
    public double calculateInsurance(){
        return getRentalRate()*0.05;
    }
    public String getInsuranceDetails(){
        return "Bike Insurance";
    }
}

class Truck extends Vehicle implements Insurable{
    private String insurancePolicyNumber;
    public Truck(String vehicleNumber,double rentalRate,String insurancePolicyNumber){
        super(vehicleNumber,"Truck",rentalRate);
        this.insurancePolicyNumber=insurancePolicyNumber;
    }
    public double calculateRentalCost(int days){
        return getRentalRate()*days*1.5;
    }
    public double calculateInsurance(){
        return getRentalRate()*0.15;
    }
    public String getInsuranceDetails(){
        return "Truck Insurance";
    }
}

public class VehicleRentalSystem{
    public static void main(String[] args){
        ArrayList<Vehicle> vehicles=new ArrayList<>();
        vehicles.add(new Car("CAR101",2000,"CARPOL123"));
        vehicles.add(new Bike("BIKE201",800,"BIKEPOL456"));
        vehicles.add(new Truck("TRUCK301",5000,"TRUCKPOL789"));
        int days=5;
        for(Vehicle v:vehicles){
            double rentalCost=v.calculateRentalCost(days);
            double insuranceCost=0;
            if(v instanceof Insurable){
                insuranceCost=((Insurable)v).calculateInsurance();
            }
            System.out.println(v.getType()+" Rental:"+rentalCost+" Insurance:"+insuranceCost);
        }
    }
}
