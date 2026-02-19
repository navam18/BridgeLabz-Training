import java.util.*;

enum Specialization {
    CARDIOLOGY,
    DERMATOLOGY,
    NEUROLOGY,
    ORTHOPEDIC
}

class SlotUnavailableException extends Exception {
    SlotUnavailableException(String message) {
        super(message);
    }
}

class Doctor {
    private int doctorId;
    private String name;
    private Specialization specialization;
    private Set<String> availableSlots;

    Doctor(int doctorId, String name, Specialization specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.availableSlots = new HashSet<>();
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void addSlot(String slot) {
        availableSlots.add(slot);
    }

    public boolean isSlotAvailable(String slot) {
        return availableSlots.contains(slot);
    }

    public void removeSlot(String slot) {
        availableSlots.remove(slot);
    }

    public Set<String> getAvailableSlots() {
        return availableSlots;
    }
}

class Appointment {
    private String patientName;
    private Doctor doctor;
    private String slot;

    Appointment(String patientName, Doctor doctor, String slot) {
        this.patientName = patientName;
        this.doctor = doctor;
        this.slot = slot;
    }

    public String toString() {
        return "Patient: " + patientName +
               ", Doctor: " + doctor.getName() +
               ", Specialization: " + doctor.getSpecialization() +
               ", Slot: " + slot;
    }
}

class ConsultationScheduler {

    private Map<Specialization, List<Doctor>> doctorMap;
    private List<Appointment> consultationHistory;

    ConsultationScheduler() {
        doctorMap = new HashMap<>();
        consultationHistory = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctorMap
            .computeIfAbsent(doctor.getSpecialization(), k -> new ArrayList<>())
            .add(doctor);
    }

    public void bookAppointment(String patientName, Specialization specialization, int doctorId, String slot)
            throws SlotUnavailableException {

        List<Doctor> doctors = doctorMap.get(specialization);

        if (doctors == null) {
            throw new SlotUnavailableException("No doctors available for this specialization");
        }

        Doctor selectedDoctor = null;

        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId() == doctorId) {
                selectedDoctor = doctor;
                break;
            }
        }

        if (selectedDoctor == null) {
            throw new SlotUnavailableException("Doctor not found");
        }

        if (!selectedDoctor.isSlotAvailable(slot)) {
            throw new SlotUnavailableException("Slot already booked or not available");
        }

        selectedDoctor.removeSlot(slot);

        Appointment appointment = new Appointment(patientName, selectedDoctor, slot);
        consultationHistory.add(appointment);

        System.out.println("Appointment booked successfully!");
    }

    public void showDoctors() {
        for (Map.Entry<Specialization, List<Doctor>> entry : doctorMap.entrySet()) {
            System.out.println("Specialization: " + entry.getKey());
            for (Doctor doctor : entry.getValue()) {
                System.out.println("Doctor ID: " + doctor.getDoctorId() +
                                   ", Name: " + doctor.getName() +
                                   ", Available Slots: " + doctor.getAvailableSlots());
            }
        }
    }

    public void showConsultationHistory() {
        for (Appointment appointment : consultationHistory) {
            System.out.println(appointment);
        }
    }
}

public class OnlineDoctorConsultationScheduler {

    public static void main(String[] args) {

        ConsultationScheduler scheduler = new ConsultationScheduler();

        Doctor d1 = new Doctor(1, "Dr. Sharma", Specialization.CARDIOLOGY);
        d1.addSlot("10AM");
        d1.addSlot("11AM");

        Doctor d2 = new Doctor(2, "Dr. Mehta", Specialization.DERMATOLOGY);
        d2.addSlot("12PM");
        d2.addSlot("1PM");

        scheduler.addDoctor(d1);
        scheduler.addDoctor(d2);

        System.out.println("Available Doctors:");
        scheduler.showDoctors();

        try {
            scheduler.bookAppointment("Rahul", Specialization.CARDIOLOGY, 1, "10AM");
            scheduler.bookAppointment("Aman", Specialization.CARDIOLOGY, 1, "10AM");
        } 
        catch (SlotUnavailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nConsultation History:");
        scheduler.showConsultationHistory();
    }
}
