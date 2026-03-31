

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Timer {

    @LogExecutionTime
    void slowMethod() {
        for (int i = 0; i < 1_000_000; i++);
    }
}

public class LogTest {
    public static void main(String[] args) throws Exception {
        Timer t = new Timer();
        long start = System.nanoTime();
        t.slowMethod();
        long end = System.nanoTime();

        System.out.println("Time: " + (end - start));
    }
}
