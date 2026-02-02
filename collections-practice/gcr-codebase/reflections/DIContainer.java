import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Inject {
}
class EmailService {
    public void send() {
        System.out.println("Email sent");
    }
}

class UserService {
    @Inject
    private EmailService emailService;

    public void process() {
        emailService.send();
    }
}

class DIContainer {

    private Map<Class<?>, Object> instances = new HashMap<>();

    public <T> T getBean(Class<T> clazz) throws Exception {

        if (instances.containsKey(clazz)) {
            return clazz.cast(instances.get(clazz));
        }

        T instance = clazz.getDeclaredConstructor().newInstance();
        instances.put(clazz, instance);

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                Object dependency = getBean(field.getType());
                field.set(instance, dependency);
            }
        }
        return instance;
    }
}
class MainAnnotation{
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        UserService service = container.getBean(UserService.class);
        service.process();

    }
}