package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Patient;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientDAO {

    @Override
    public int insertPatient(Patient patient) {
        String sql = "INSERT INTO patients (first_name, last_name, date_of_birth, gender, phone_number, email) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            if (patient.getDateOfBirth() != null) {
                pstmt.setDate(3, Date.valueOf(patient.getDateOfBirth()));
            } else {
                pstmt.setNull(3, Types.DATE);
            }
            pstmt.setString(4, patient.getGender());
            pstmt.setString(5, patient.getPhoneNumber());
            pstmt.setString(6, patient.getEmail());

            pstmt.executeUpdate();

            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Insert patient failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patients WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Fetch patient failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients ORDER BY patient_id";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) patients.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Fetch all patients failed: " + e.getMessage());
        }
        return patients;
    }

    @Override
    public List<Patient> searchByName(String namePart) {
        List<Patient> patients = new ArrayList<>();
        String sql = "SELECT * FROM patients WHERE first_name LIKE ? OR last_name LIKE ? ORDER BY patient_id";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String pattern = "%" + namePart + "%";
            pstmt.setString(1, pattern);
            pstmt.setString(2, pattern);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) patients.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.out.println("Search patients failed: " + e.getMessage());
        }
        return patients;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patients SET first_name=?, last_name=?, date_of_birth=?, gender=?, " +
                "phone_number=?, email=? WHERE patient_id=?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, patient.getFirstName());
            pstmt.setString(2, patient.getLastName());
            if (patient.getDateOfBirth() != null) {
                pstmt.setDate(3, Date.valueOf(patient.getDateOfBirth()));
            } else {
                pstmt.setNull(3, Types.DATE);
            }
            pstmt.setString(4, patient.getGender());
            pstmt.setString(5, patient.getPhoneNumber());
            pstmt.setString(6, patient.getEmail());
            pstmt.setInt(7, patient.getPatientId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update patient failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deactivatePatient(int id) {
        String sql = "UPDATE patients SET is_active = FALSE WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Deactivate patient failed: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deletePatient(int id) {
        String sql = "DELETE FROM patients WHERE patient_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            // Most common cause: patient has appointments (FK constraint) — that's expected, not a bug.
            System.out.println("Delete patient failed (they may have existing appointments): " + e.getMessage());
            return false;
        }
    }

    private Patient mapRow(ResultSet rs) throws SQLException {
        Patient p = new Patient();
        p.setPatientId(rs.getInt("patient_id"));
        p.setFirstName(rs.getString("first_name"));
        p.setLastName(rs.getString("last_name"));
        Date dob = rs.getDate("date_of_birth");
        p.setDateOfBirth(dob != null ? dob.toLocalDate() : null);
        p.setGender(rs.getString("gender"));
        p.setPhoneNumber(rs.getString("phone_number"));
        p.setEmail(rs.getString("email"));
        p.setActive(rs.getBoolean("is_active"));
        p.setRegisteredOn(rs.getTimestamp("registered_on"));
        return p;
    }
}
