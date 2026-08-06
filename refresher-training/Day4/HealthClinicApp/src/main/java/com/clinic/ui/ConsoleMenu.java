package com.clinic.ui;

import com.clinic.dao.*;
import com.clinic.dto.*;
import com.clinic.service.AppointmentService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Floor 4 — what the receptionist sees. Only ever calls DAOs or the Service
 * layer; never contains SQL itself.
 */
public class ConsoleMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final SpecializationDAO specializationDAO = new SpecializationDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService();

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATETIME_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== Health Clinic Management System =====");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Specialization Management");
            System.out.println("4. Appointment Management");
            System.out.println("5. Billing");
            System.out.println("6. Visit History");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = readInt();
            switch (choice) {
                case 1 -> patientMenu();
                case 2 -> doctorMenu();
                case 3 -> specializationMenu();
                case 4 -> appointmentMenu();
                case 5 -> billingMenu();
                case 6 -> visitHistoryMenu();
                case 0 -> running = false;
                default -> System.out.println("Invalid choice.");
            }
        }
        System.out.println("Goodbye!");
    }

    // ---------------------------------------------------------------- PATIENTS
    private void patientMenu() {
        System.out.println("\n-- Patient Management --");
        System.out.println("1. Register patient");
        System.out.println("2. View patient by ID");
        System.out.println("3. List all patients");
        System.out.println("4. Search patients by name");
        System.out.println("5. Update patient");
        System.out.println("6. Deactivate patient (soft delete)");
        System.out.println("7. Delete patient permanently");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");

        switch (readInt()) {
            case 1 -> registerPatient();
            case 2 -> {
                int id = readInt("Patient ID: ");
                Patient p = patientDAO.getPatientById(id);
                System.out.println(p != null ? p : "No patient found with that ID.");
            }
            case 3 -> printList(patientDAO.getAllPatients());
            case 4 -> {
                String name = readLine("Name contains: ");
                printList(patientDAO.searchByName(name));
            }
            case 5 -> updatePatient();
            case 6 -> {
                int id = readInt("Patient ID to deactivate: ");
                System.out.println(patientDAO.deactivatePatient(id) ? "Deactivated." : "Failed.");
            }
            case 7 -> {
                int id = readInt("Patient ID to delete: ");
                System.out.println(patientDAO.deletePatient(id) ? "Deleted." : "Failed.");
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void registerPatient() {
        String first = readLine("First name: ");
        String last = readLine("Last name: ");
        LocalDate dob = readOptionalDate("Date of birth (yyyy-MM-dd, blank to skip): ");
        String gender = readLine("Gender (Male/Female/Other): ");
        String phone = readLine("Phone number: ");
        String email = readLine("Email: ");

        Patient p = new Patient(first, last, dob, gender, phone, email);
        int id = patientDAO.insertPatient(p);
        System.out.println(id > 0 ? "Registered with ID: " + id : "Registration failed.");
    }

    private void updatePatient() {
        int id = readInt("Patient ID to update: ");
        Patient existing = patientDAO.getPatientById(id);
        if (existing == null) {
            System.out.println("No patient found with that ID.");
            return;
        }
        System.out.println("Leave blank to keep current value.");
        String first = readLine("First name [" + existing.getFirstName() + "]: ");
        String last = readLine("Last name [" + existing.getLastName() + "]: ");
        String phone = readLine("Phone [" + existing.getPhoneNumber() + "]: ");
        String email = readLine("Email [" + existing.getEmail() + "]: ");

        if (!first.isBlank()) existing.setFirstName(first);
        if (!last.isBlank()) existing.setLastName(last);
        if (!phone.isBlank()) existing.setPhoneNumber(phone);
        if (!email.isBlank()) existing.setEmail(email);

        System.out.println(patientDAO.updatePatient(existing) ? "Updated." : "Update failed.");
    }

    // ---------------------------------------------------------------- DOCTORS
    private void doctorMenu() {
        System.out.println("\n-- Doctor Management --");
        System.out.println("1. Register doctor");
        System.out.println("2. View doctor by ID (with specializations)");
        System.out.println("3. List all doctors");
        System.out.println("4. Update doctor");
        System.out.println("5. Deactivate doctor");
        System.out.println("6. Delete doctor permanently");
        System.out.println("7. Assign specialization to doctor");
        System.out.println("8. Remove specialization from doctor");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");

        switch (readInt()) {
            case 1 -> registerDoctor();
            case 2 -> {
                int id = readInt("Doctor ID: ");
                Doctor d = doctorDAO.getDoctorById(id);
                System.out.println(d != null ? d + "\nSpecializations: " + d.getSpecializations() : "No doctor found.");
            }
            case 3 -> printList(doctorDAO.getAllDoctors());
            case 4 -> updateDoctor();
            case 5 -> {
                int id = readInt("Doctor ID to deactivate: ");
                System.out.println(doctorDAO.deactivateDoctor(id) ? "Deactivated." : "Failed.");
            }
            case 6 -> {
                int id = readInt("Doctor ID to delete: ");
                System.out.println(doctorDAO.deleteDoctor(id) ? "Deleted." : "Failed.");
            }
            case 7 -> {
                int doctorId = readInt("Doctor ID: ");
                int specId = readInt("Specialization ID: ");
                System.out.println(doctorDAO.assignSpecialization(doctorId, specId) ? "Assigned." : "Failed.");
            }
            case 8 -> {
                int doctorId = readInt("Doctor ID: ");
                int specId = readInt("Specialization ID: ");
                System.out.println(doctorDAO.removeSpecialization(doctorId, specId) ? "Removed." : "Failed.");
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void registerDoctor() {
        String first = readLine("First name: ");
        String last = readLine("Last name: ");
        String phone = readLine("Phone number: ");
        String email = readLine("Email: ");
        Doctor d = new Doctor(first, last, phone, email);
        int id = doctorDAO.insertDoctor(d);
        System.out.println(id > 0 ? "Registered with ID: " + id : "Registration failed.");
    }

    private void updateDoctor() {
        int id = readInt("Doctor ID to update: ");
        Doctor existing = doctorDAO.getDoctorById(id);
        if (existing == null) {
            System.out.println("No doctor found with that ID.");
            return;
        }
        System.out.println("Leave blank to keep current value.");
        String first = readLine("First name [" + existing.getFirstName() + "]: ");
        String last = readLine("Last name [" + existing.getLastName() + "]: ");
        String phone = readLine("Phone [" + existing.getPhoneNumber() + "]: ");
        String email = readLine("Email [" + existing.getEmail() + "]: ");

        if (!first.isBlank()) existing.setFirstName(first);
        if (!last.isBlank()) existing.setLastName(last);
        if (!phone.isBlank()) existing.setPhoneNumber(phone);
        if (!email.isBlank()) existing.setEmail(email);

        System.out.println(doctorDAO.updateDoctor(existing) ? "Updated." : "Update failed.");
    }

    // ---------------------------------------------------------------- SPECIALIZATIONS
    private void specializationMenu() {
        System.out.println("\n-- Specialization Management --");
        System.out.println("1. Add specialization");
        System.out.println("2. View specialization by ID");
        System.out.println("3. List all specializations");
        System.out.println("4. Update specialization");
        System.out.println("5. Delete specialization");
        System.out.println("6. List doctors by specialization");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");

        switch (readInt()) {
            case 1 -> {
                String name = readLine("Name: ");
                String desc = readLine("Description: ");
                int id = specializationDAO.insertSpecialization(new Specialization(name, desc));
                System.out.println(id > 0 ? "Added with ID: " + id : "Add failed.");
            }
            case 2 -> {
                int id = readInt("Specialization ID: ");
                Specialization s = specializationDAO.getSpecializationById(id);
                System.out.println(s != null ? s : "Not found.");
            }
            case 3 -> printList(specializationDAO.getAllSpecializations());
            case 4 -> {
                int id = readInt("Specialization ID to update: ");
                Specialization existing = specializationDAO.getSpecializationById(id);
                if (existing == null) {
                    System.out.println("Not found.");
                    break;
                }
                String name = readLine("Name [" + existing.getName() + "]: ");
                String desc = readLine("Description [" + existing.getDescription() + "]: ");
                if (!name.isBlank()) existing.setName(name);
                if (!desc.isBlank()) existing.setDescription(desc);
                System.out.println(specializationDAO.updateSpecialization(existing) ? "Updated." : "Update failed.");
            }
            case 5 -> {
                int id = readInt("Specialization ID to delete: ");
                System.out.println(specializationDAO.deleteSpecialization(id) ? "Deleted." : "Failed.");
            }
            case 6 -> {
                int id = readInt("Specialization ID: ");
                printList(doctorDAO.getDoctorsBySpecialization(id));
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    // ---------------------------------------------------------------- APPOINTMENTS
    private void appointmentMenu() {
        System.out.println("\n-- Appointment Management --");
        System.out.println("1. Book appointment");
        System.out.println("2. View appointment by ID");
        System.out.println("3. List all appointments");
        System.out.println("4. List appointments by patient");
        System.out.println("5. List appointments by doctor");
        System.out.println("6. Complete appointment (creates bill + visit record)");
        System.out.println("7. Cancel appointment");
        System.out.println("8. Delete appointment permanently");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");

        switch (readInt()) {
            case 1 -> bookAppointment();
            case 2 -> {
                int id = readInt("Appointment ID: ");
                Appointment a = appointmentDAO.getAppointmentById(id);
                System.out.println(a != null ? a : "Not found.");
            }
            case 3 -> printList(appointmentDAO.getAllAppointments());
            case 4 -> {
                int id = readInt("Patient ID: ");
                printList(appointmentDAO.getAppointmentsByPatient(id));
            }
            case 5 -> {
                int id = readInt("Doctor ID: ");
                printList(appointmentDAO.getAppointmentsByDoctor(id));
            }
            case 6 -> completeAppointment();
            case 7 -> {
                int id = readInt("Appointment ID to cancel: ");
                System.out.println(appointmentService.cancelAppointment(id) ? "Cancelled." : "Cancel failed.");
            }
            case 8 -> {
                int id = readInt("Appointment ID to delete: ");
                System.out.println(appointmentDAO.deleteAppointment(id) ? "Deleted." : "Failed.");
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    private void bookAppointment() {
        int patientId = readInt("Patient ID: ");
        int doctorId = readInt("Doctor ID: ");
        LocalDateTime dateTime = readDateTime("Appointment date/time (yyyy-MM-dd HH:mm): ");

        Appointment a = new Appointment(patientId, doctorId, dateTime);
        int id = appointmentService.bookAppointment(a);
        System.out.println(id > 0 ? "Booked with ID: " + id : "Booking failed.");
    }

    private void completeAppointment() {
        int id = readInt("Appointment ID: ");
        BigDecimal amount = readAmount("Bill amount: ");
        String diagnosis = readLine("Diagnosis: ");
        String prescription = readLine("Prescription: ");
        String notes = readLine("Visit notes: ");

        boolean success = appointmentService.completeAppointment(id, amount, diagnosis, prescription, notes);
        System.out.println(success ? "Appointment completed! Bill and visit record created." : "Something went wrong.");
    }

    // ---------------------------------------------------------------- BILLING
    private void billingMenu() {
        System.out.println("\n-- Billing --");
        System.out.println("1. View bill by ID");
        System.out.println("2. View bill by appointment ID");
        System.out.println("3. List all bills");
        System.out.println("4. Update payment status");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");

        switch (readInt()) {
            case 1 -> {
                int id = readInt("Bill ID: ");
                Billing b = billingDAO.getBillingById(id);
                System.out.println(b != null ? b : "Not found.");
            }
            case 2 -> {
                int id = readInt("Appointment ID: ");
                Billing b = billingDAO.getBillingByAppointmentId(id);
                System.out.println(b != null ? b : "No bill for that appointment.");
            }
            case 3 -> printList(billingDAO.getAllBillings());
            case 4 -> {
                int id = readInt("Bill ID: ");
                String status = readLine("New status (Pending/Paid/Refunded): ");
                System.out.println(billingDAO.updatePaymentStatus(id, status) ? "Updated." : "Update failed.");
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    // ---------------------------------------------------------------- VISIT HISTORY
    private void visitHistoryMenu() {
        System.out.println("\n-- Visit History --");
        System.out.println("1. View visit by ID");
        System.out.println("2. View visit by appointment ID");
        System.out.println("3. List all visit records");
        System.out.println("4. Update visit record");
        System.out.println("0. Back");
        System.out.print("Choose an option: ");

        switch (readInt()) {
            case 1 -> {
                int id = readInt("Visit ID: ");
                VisitHistory v = visitHistoryDAO.getVisitHistoryById(id);
                System.out.println(v != null ? v : "Not found.");
            }
            case 2 -> {
                int id = readInt("Appointment ID: ");
                VisitHistory v = visitHistoryDAO.getVisitHistoryByAppointmentId(id);
                System.out.println(v != null ? v : "No visit record for that appointment.");
            }
            case 3 -> printList(visitHistoryDAO.getAllVisitHistory());
            case 4 -> {
                int id = readInt("Visit ID to update: ");
                VisitHistory existing = visitHistoryDAO.getVisitHistoryById(id);
                if (existing == null) {
                    System.out.println("Not found.");
                    break;
                }
                String diagnosis = readLine("Diagnosis [" + existing.getDiagnosis() + "]: ");
                String prescription = readLine("Prescription [" + existing.getPrescription() + "]: ");
                String notes = readLine("Notes [" + existing.getVisitNotes() + "]: ");
                if (!diagnosis.isBlank()) existing.setDiagnosis(diagnosis);
                if (!prescription.isBlank()) existing.setPrescription(prescription);
                if (!notes.isBlank()) existing.setVisitNotes(notes);
                System.out.println(visitHistoryDAO.updateVisitHistory(existing) ? "Updated." : "Update failed.");
            }
            case 0 -> { }
            default -> System.out.println("Invalid choice.");
        }
    }

    // ---------------------------------------------------------------- input helpers
    private <T> void printList(List<T> items) {
        if (items.isEmpty()) {
            System.out.println("(no records found)");
            return;
        }
        items.forEach(System.out::println);
    }

    private int readInt(String prompt) {
        System.out.print(prompt);
        return readInt();
    }

    private int readInt() {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a whole number: ");
            }
        }
    }

    private String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private LocalDate readOptionalDate(String prompt) {
        System.out.print(prompt);
        String line = scanner.nextLine().trim();
        if (line.isBlank()) return null;
        try {
            return LocalDate.parse(line, DATE_FMT);
        } catch (Exception e) {
            System.out.println("Couldn't parse that date, leaving it blank.");
            return null;
        }
    }

    private LocalDateTime readDateTime(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return LocalDateTime.parse(line, DATETIME_FMT);
            } catch (Exception e) {
                System.out.print("Couldn't parse that — use format yyyy-MM-dd HH:mm. ");
            }
        }
    }

    private BigDecimal readAmount(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return new BigDecimal(line);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
