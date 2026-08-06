package com.clinic.dao;

import com.clinic.config.HikariConnectionPool;
import com.clinic.dto.Billing;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillingDAOImpl implements BillingDAO {

    @Override
    public int insertBilling(Billing billing) {
        String sql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, ?)";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setInt(1, billing.getAppointmentId());
            pstmt.setBigDecimal(2, billing.getAmount());
            pstmt.setString(3, billing.getPaymentStatus() != null ? billing.getPaymentStatus() : "Pending");
            pstmt.executeUpdate();
            try (ResultSet keys = pstmt.getGeneratedKeys()) {
                if (keys.next()) return keys.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Insert billing failed: " + e.getMessage());
        }
        return -1;
    }

    @Override
    public void insertBilling(Connection conn, int appointmentId, BigDecimal amount) throws SQLException {
        String sql = "INSERT INTO billing (appointment_id, amount, payment_status) VALUES (?, ?, 'Pending')";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            pstmt.setBigDecimal(2, amount);
            pstmt.executeUpdate();
        }
    }

    @Override
    public Billing getBillingById(int id) {
        String sql = "SELECT * FROM billing WHERE bill_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Fetch billing failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Billing getBillingByAppointmentId(int appointmentId) {
        String sql = "SELECT * FROM billing WHERE appointment_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, appointmentId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        } catch (SQLException e) {
            System.out.println("Fetch billing by appointment failed: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Billing> getAllBillings() {
        List<Billing> list = new ArrayList<>();
        String sql = "SELECT * FROM billing ORDER BY bill_id DESC";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) list.add(mapRow(rs));
        } catch (SQLException e) {
            System.out.println("Fetch all billings failed: " + e.getMessage());
        }
        return list;
    }

    @Override
    public boolean updatePaymentStatus(int billId, String status) {
        String sql = "UPDATE billing SET payment_status = ? WHERE bill_id = ?";
        try (Connection conn = HikariConnectionPool.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, billId);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Update payment status failed: " + e.getMessage());
            return false;
        }
    }

    private Billing mapRow(ResultSet rs) throws SQLException {
        Billing b = new Billing();
        b.setBillId(rs.getInt("bill_id"));
        b.setAppointmentId(rs.getInt("appointment_id"));
        b.setAmount(rs.getBigDecimal("amount"));
        b.setPaymentStatus(rs.getString("payment_status"));
        b.setBillingDate(rs.getTimestamp("billing_date"));
        return b;
    }
}
