package junit.example;

public class PerformanceTask {

    public static String longRunningTask() throws InterruptedException {
        Thread.sleep(3000); // 3 seconds
        return "Done";
    }
}