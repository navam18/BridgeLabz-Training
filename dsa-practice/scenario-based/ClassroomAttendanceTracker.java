import java.util.*;


class DuplicateAttendanceException extends Exception {
    public DuplicateAttendanceException(String message) {
        super(message);
    }
}

class Student {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student{id='" + studentId + "', name='" + name + "'}";
    }
}

class Session {
    private String sessionId;
    private String topic;

    public Session(String sessionId, String topic) {
        this.sessionId = sessionId;
        this.topic = topic;
    }

    public String getSessionId() {
        return sessionId;
    }

    @Override
    public String toString() {
        return "Session{id='" + sessionId + "', topic='" + topic + "'}";
    }
}







public class ClassroomAttendanceTracker {

    // Map<SessionID, Set<StudentID>>
    private Map<String, Set<String>> attendanceMap = new HashMap<>();

    // Mark attendance
    public void markAttendance(String sessionId, String studentId) throws DuplicateAttendanceException {
        attendanceMap.putIfAbsent(sessionId, new HashSet<>());

        Set<String> students = attendanceMap.get(sessionId);
        if (students.contains(studentId)) {
            throw new DuplicateAttendanceException("Student " + studentId + " already marked for session " + sessionId);
        }

        students.add(studentId);
        System.out.println("Marked attendance for student " + studentId + " in session " + sessionId);
    }

    // Remove attendance
    public void removeAttendance(String sessionId, String studentId) {
        Set<String> students = attendanceMap.get(sessionId);
        if (students != null && students.remove(studentId)) {
            System.out.println("Removed attendance for student " + studentId + " from session " + sessionId);
        } else {
            System.out.println("No attendance found to remove for student " + studentId + " in session " + sessionId);
        }
    }

    // Display attendance for a session
    public void displayAttendance(String sessionId) {
        Set<String> students = attendanceMap.get(sessionId);
        if (students == null || students.isEmpty()) {
            System.out.println("No attendance for session " + sessionId);
        } else {
            System.out.println("Attendance for session " + sessionId + ": " + students);
        }
    }

    // Display all sessions
    public void displayAllAttendance() {
        if (attendanceMap.isEmpty()) {
            System.out.println("No attendance recorded yet.");
            return;
        }
        for (Map.Entry<String, Set<String>> entry : attendanceMap.entrySet()) {
            System.out.println("Session " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
