package com.clinic.dao;

import com.clinic.dto.VisitHistory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface VisitHistoryDAO {
    int insertVisitHistory(VisitHistory visitHistory);
    VisitHistory getVisitHistoryById(int id);
    VisitHistory getVisitHistoryByAppointmentId(int appointmentId);
    List<VisitHistory> getAllVisitHistory();
    boolean updateVisitHistory(VisitHistory visitHistory);

    // Used by the Service layer so the insert participates in a shared transaction.
    void insertVisitHistory(Connection conn, int appointmentId, String diagnosis,
                             String prescription, String notes) throws SQLException;
}
