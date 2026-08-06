package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.VisitHistory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VisitHistoryDAOImpl implements VisitHistoryDAO {

    @Override
    public int insertVisitHistory(VisitHistory visitHistory) {
        String sql = "INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes) VALUES (?, ?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, visitHistory.getAppointmentId());
            pstmt.setString(2, visitHistory.getDiagnosis());
            pstmt.setString(3, visitHistory.getPrescription());
            pstmt.setString(4, visitHistory.getVisitNotes());
            pstmt.executeUpdate();
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Insert visit history failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public void insertVisitHistory(Connection conn, int appointmentId, String diagnosis,
                                    String prescription, String notes) throws SQLException {
        String sql = "INSERT INTO visit_history (appointment_id, diagnosis, prescription, visit_notes) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            pstmt.setString(2, diagnosis);
            pstmt.setString(3, prescription);
            pstmt.setString(4, notes);
            pstmt.executeUpdate();
        }
    }

    @Override
    public VisitHistory getVisitHistoryById(int id) {
        String sql = "SELECT * FROM visit_history WHERE visit_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Fetch visit history failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public VisitHistory getVisitHistoryByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM visit_history WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Fetch visit history by appointment failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<VisitHistory> getAllVisitHistory() {
        List<VisitHistory> list = new ArrayList<>();
        String sql = "SELECT * FROM visit_history ORDER BY visit_id DESC";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Fetch all visit history failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updateVisitHistory(VisitHistory visitHistory) {
        String sql = "UPDATE visit_history SET diagnosis=?, prescription=?, visit_notes=? WHERE visit_id=?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, visitHistory.getDiagnosis());
            pstmt.setString(2, visitHistory.getPrescription());
            pstmt.setString(3, visitHistory.getVisitNotes());
            pstmt.setInt(4, visitHistory.getVisitId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update visit history failed: " + e.getMessage());
            return false;
        }
    }

    private VisitHistory mapRow(ResultSet rs) throws SQLException {
        VisitHistory v = new VisitHistory();
        v.setVisitId(rs.getInt("visit_id"));
        v.setAppointmentId(rs.getInt("appointment_id"));
        v.setDiagnosis(rs.getString("diagnosis"));
        v.setPrescription(rs.getString("prescription"));
        v.setVisitNotes(rs.getString("visit_notes"));
        return v;
    }
}
