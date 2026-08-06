package com.clinic.dao;

import com.clinic.dto.Patient;

import java.util.List;

public interface PatientDAO {
    int insertPatient(Patient patient);
    Patient getPatientById(int id);
    List<Patient> getAllPatients();
    List<Patient> searchByName(String namePart);
    boolean updatePatient(Patient patient);
    boolean deactivatePatient(int id); // soft delete via is_active
    boolean deletePatient(int id);     // hard delete (only if no appointments reference it)
}
