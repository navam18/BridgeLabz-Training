import java.lang.reflect.Field;
import java.util.Map;

class User {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}
public class SimpleObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties)
            throws Exception {

        T instance = clazz.getDeclaredConstructor().newInstance();

        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            String fieldName = entry.getKey();
            Object value = entry.getValue();

            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        }
        return instance;
    }
}
class MainExecutionClass{
    public static void main(String[] args) throws Exception {
        Map<String, Object> data = Map.of(
                "name", "Divyansh",
                "age", 23
        );
        User user = SimpleObjectMapper.toObject(User.class, data);
        System.out.println(user);

    }
}
