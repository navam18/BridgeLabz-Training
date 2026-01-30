package src.test.java;

import org.junit.jupiter.api.Test;
import src.main.java.org.example.DateFormatter;

import static org.junit.jupiter.api.Assertions.*;

class DateFormatterTest {

    @Test
    void testValidDateFormatting() {
        assertEquals("25-01-2026",
                DateFormatter.formatDate("2026-01-25"));
    }

    @Test
    void testInvalidDateThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> DateFormatter.formatDate("25-01-2026"));
    }
}