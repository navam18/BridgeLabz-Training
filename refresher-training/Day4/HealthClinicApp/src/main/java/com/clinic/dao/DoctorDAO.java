package com.clinic.dao;

import com.clinic.dto.Doctor;

import java.util.List;

public interface DoctorDAO {
    int insertDoctor(Doctor doctor);
    Doctor getDoctorById(int id);
    List<Doctor> getAllDoctors();
    boolean updateDoctor(Doctor doctor);
    boolean deactivateDoctor(int id);
    boolean deleteDoctor(int id);

    // Many-to-many with specializations
    boolean assignSpecialization(int doctorId, int specializationId);
    boolean removeSpecialization(int doctorId, int specializationId);
    List<Doctor> getDoctorsBySpecialization(int specializationId);
}
