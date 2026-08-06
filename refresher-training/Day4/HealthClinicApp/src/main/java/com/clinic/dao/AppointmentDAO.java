package com.clinic.dao;

import com.clinic.dto.Appointment;

import java.sql.Connection;
import java.util.List;

public interface AppointmentDAO {
    int insertAppointment(Appointment appointment);
    Appointment getAppointmentById(int id);
    List<Appointment> getAllAppointments();
    List<Appointment> getAppointmentsByPatient(int patientId);
    List<Appointment> getAppointmentsByDoctor(int doctorId);
    boolean updateStatus(int appointmentId, String status);
    boolean deleteAppointment(int id);

    // Used by the Service layer so status update participates in a shared transaction.
    void updateStatus(Connection conn, int appointmentId, String status) throws java.sql.SQLException;
}
