class VehicleRegistrationSystem {

    // Static variable
    static double registrationFee = 150.0;

    // Instance variables
    final String registrationNumber;   // final
    String ownerName;
    String vehicleType;

    // Constructor using this
    VehicleRegistrationSystem(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method
    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    // Display details
    void displayDetails(Object obj) {
        if (obj instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }

    public static void main(String[] args) {
        VehicleRegistrationSystem v1 = new VehicleRegistrationSystem("Honest raj", "Sedan", "ABC123");
        VehicleRegistrationSystem v2 = new VehicleRegistrationSystem("Price danish", "SUV", "XYZ789");

        v1.displayDetails(v1);
        System.out.println();
        v2.displayDetails(v2);
    }
}
