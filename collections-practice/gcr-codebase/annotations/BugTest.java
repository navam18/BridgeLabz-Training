

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

class App {

    @BugReport(description = "Null Pointer")
    @BugReport(description = "Memory Leak")
    void run() {}
}

public class BugTest {
    public static void main(String[] args) throws Exception {
        Method m = App.class.getDeclaredMethod("run");

        for (BugReport b : m.getAnnotationsByType(BugReport.class)) {
            System.out.println(b.description());
        }
    }
}

