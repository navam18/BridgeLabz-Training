class CarRental{
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay;

    CarRental(){
        customerName="";
        carModel="";
        rentalDays=0;
        costPerDay=0.0;
    }

    CarRental(String customerName,String carModel,int rentalDays,double costPerDay){
        this.customerName=customerName;
        this.carModel=carModel;
        this.rentalDays=rentalDays;
        this.costPerDay=costPerDay;
    }

    double calculateTotalCost(){
        return rentalDays*costPerDay;
    }

    public static void main(String[] args){
        CarRental r1=new CarRental();
        CarRental r2=new CarRental("Rohit","Swift",5,1500.0);
        double totalCost=r2.calculateTotalCost();
        System.out.println("Total Rental Cost for " + r2.customerName + " is " + totalCost);
    }
}
