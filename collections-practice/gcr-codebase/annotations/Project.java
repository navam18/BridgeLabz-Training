
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {

    @Todo(task = "Add login", assignedTo = "Kapil")
    void login() {}

    @Todo(task = "Payment gateway", assignedTo = "Aman", priority = "HIGH")
    void payment() {}
}

