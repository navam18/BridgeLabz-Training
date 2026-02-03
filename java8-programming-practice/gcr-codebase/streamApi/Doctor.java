import java.util.*;
class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekend;
    Doctor(String name, String specialty, boolean availableOnWeekend) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekend = availableOnWeekend;
    }
    public String toString() {
        return name + " - " + specialty;
    }
}
class Main {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Amit", "Cardiology", true),
            new Doctor("Dr. Neha", "Neurology", false),
            new Doctor("Dr. Raj", "Orthopedics", true),
            new Doctor("Dr. Simran", "Dermatology", true),
            new Doctor("Dr. Kunal", "Cardiology", false)
        );
        doctors.stream()
               .filter(d -> d.availableOnWeekend)      // filter
               .sorted(Comparator.comparing(d -> d.specialty)) // sorted
                .forEach(System.out::println);
    }
}