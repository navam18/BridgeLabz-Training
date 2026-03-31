import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OLD_KEY";
}

public class StaticFieldDemo {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Configuration.class;
        Field field = clazz.getDeclaredField("API_KEY");

        field.setAccessible(true);
        field.set(null, "NEW_SECRET_KEY"); // null for static fields

        System.out.println("API_KEY = " + field.get(null));
    }
}
