import java.lang.reflect.*;

public class ClassInfoDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String className = "java.util.ArrayList";
        Class<?> clazz = Class.forName(className);
        System.out.println("Class Name: " + clazz.getName());
        System.out.println("\n--- Fields ---");
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println(field);
        }
        System.out.println("\n--- Constructors ---");
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            System.out.println(constructor);
        }
        System.out.println("\n--- Methods ---");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method);
        }
    }
}
