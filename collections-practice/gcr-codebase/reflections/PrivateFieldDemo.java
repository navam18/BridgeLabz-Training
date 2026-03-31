import java.lang.reflect.Field;
class Person{
    private int age=10;
}

public class PrivateFieldDemo {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<?> clazz = person.getClass();
        Field field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        field.set(person, 30);
        int value = (int) field.get(person);
        System.out.println("Age = " + value);
    }
}
