import java.lang.reflect.Method;
class Task {
    public void runTask() {
        try {
            Thread.sleep(500);
        } catch (Exception e) {}
    }
}

public class MethodTimer {

    public static void execute(Object obj, String methodName) throws Exception {

        Method method = obj.getClass().getMethod(methodName);

        long start = System.nanoTime();
        method.invoke(obj);
        long end = System.nanoTime();

        System.out.println("Execution time (ns): " + (end - start));
    }
}
class MainMethod{
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        MethodTimer.execute(task, "runTask");

    }
}
