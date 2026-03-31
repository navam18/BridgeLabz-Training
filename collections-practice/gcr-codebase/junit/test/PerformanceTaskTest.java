package src.test.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import src.main.java.org.example.PerformanceTask;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceTaskTest {

    @Test
    @Timeout(2) // seconds
    void testLongRunningTask_timeout() throws InterruptedException {
        PerformanceTask.longRunningTask();
    }
}