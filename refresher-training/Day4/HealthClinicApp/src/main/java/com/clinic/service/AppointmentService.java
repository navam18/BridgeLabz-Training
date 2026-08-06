package com.clinic.service;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dao.*;
import com.clinic.dto.Appointment;
import com.clinic.dto.Doctor;
import com.clinic.dto.Patient;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Coordinates multi-step actions that must succeed or fail together.
 * This is the only class in the app that manages a transaction directly.
 */
public class AppointmentService {

    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final DoctorDAO doctorDAO = new DoctorDAOImpl();
    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();
    private final BillingDAO billingDAO = new BillingDAOImpl();
    private final VisitHistoryDAO visitHistoryDAO = new VisitHistoryDAOImpl();

    /**
     * Books a new appointment after checking the patient and doctor actually exist.
     * Returns the new appointment_id, or -1 if validation or the insert failed.
     */
    public int bookAppointment(Appointment appointment) {
        Patient patient = patientDAO.getPatientById(appointment.getPatientId());
        if (patient == null) {
            System.out.println("Booking failed: no patient with ID " + appointment.getPatientId());
            return -1;
        }
        Doctor doctor = doctorDAO.getDoctorById(appointment.getDoctorId());
        if (doctor == null) {
            System.out.println("Booking failed: no doctor with ID " + appointment.getDoctorId());
            return -1;
        }
        return appointmentDAO.insertAppointment(appointment);
    }

    /**
     * Marks an appointment Completed, creates its bill, and records the visit —
     * as one all-or-nothing transaction (single connection, single commit/rollback).
     */
    public boolean completeAppointment(int appointmentId, BigDecimal amount, String diagnosis,
                                        String prescription, String notes) {
        Appointment existing = appointmentDAO.getAppointmentById(appointmentId);
        if (existing == null) {
            System.out.println("Complete failed: no appointment with ID " + appointmentId);
            return false;
        }
        if ("Completed".equals(existing.getStatus())) {
            System.out.println("Complete failed: appointment " + appointmentId + " is already completed.");
            return false;
        }
        if ("Cancelled".equals(existing.getStatus())) {
            System.out.println("Complete failed: appointment " + appointmentId + " was cancelled.");
            return false;
        }

        Connection conn = null;
        try {
            conn = HikariConnectionPool.getConnection();
            conn.setAutoCommit(false); // stop auto-saving after each statement

            // Write 1: mark appointment as completed
            appointmentDAO.updateStatus(conn, appointmentId, "Completed");

            // Write 2: create the bill
            billingDAO.insertBilling(conn, appointmentId, amount);

            // Write 3: record what happened during the visit
            visitHistoryDAO.insertVisitHistory(conn, appointmentId, diagnosis, prescription, notes);

            conn.commit(); // all 3 worked -> save everything for real
            return true;

        } catch (SQLException e) {
            System.out.println("Something failed, undoing everything: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    System.out.println("Rollback also failed: " + ex.getMessage());
                }
            }
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.setAutoCommit(true);
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Closing connection failed: " + e.getMessage());
                }
            }
        }
    }

    /** Simple single-table state change — doesn't need a shared transaction. */
    public boolean cancelAppointment(int appointmentId) {
        Appointment existing = appointmentDAO.getAppointmentById(appointmentId);
        if (existing == null) {
            System.out.println("Cancel failed: no appointment with ID " + appointmentId);
            return false;
        }
        if ("Completed".equals(existing.getStatus())) {
            System.out.println("Cancel failed: appointment " + appointmentId + " is already completed.");
            return false;
        }
        return appointmentDAO.updateStatus(appointmentId, "Cancelled");
    }
}
