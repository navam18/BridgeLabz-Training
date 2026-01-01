class HospitalManagementSystem {

    // Static variables
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;

    // Instance variables
    final String patientID;   // final
    String name;
    int age;
    String ailment;

    // Constructor using this
    HospitalManagementSystem(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // Static method
    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Display details
    void displayDetails(Object obj) {
        if (obj instanceof HospitalManagementSystem) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        }
    }

    public static void main(String[] args) {
        HospitalManagementSystem p1 = new HospitalManagementSystem("P001", "Lathika", 30, "Flu");
        HospitalManagementSystem p2 = new HospitalManagementSystem("P002", "Lidiya", 45, "Fracture");

        HospitalManagementSystem.getTotalPatients();

        p1.displayDetails(p1);
        System.out.println();
        p2.displayDetails(p2);
    }
}
