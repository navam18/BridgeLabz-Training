

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

class TaskManager {

    @TaskInfo(priority = "HIGH", assignedTo = "Kapil")
    void completeTask() {}
}

public class TaskInfoTest {
    public static void main(String[] args) throws Exception {
        Method m = TaskManager.class.getDeclaredMethod("completeTask");
        TaskInfo info = m.getAnnotation(TaskInfo.class);

        System.out.println(info.priority());
        System.out.println(info.assignedTo());
    }
}
