package com.clinic.dao;

import com.clinic.dto.Billing;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface BillingDAO {
    int insertBilling(Billing billing);
    Billing getBillingById(int id);
    Billing getBillingByAppointmentId(int appointmentId);
    List<Billing> getAllBillings();
    boolean updatePaymentStatus(int billId, String status);

    // Used by the Service layer so the insert participates in a shared transaction.
    void insertBilling(Connection conn, int appointmentId, BigDecimal amount) throws SQLException;
}
