class Student {
    public Student() {
        System.out.println("Student object created!");
    }
}

public class DynamicObjectDemo {
    public static void main(String[] args) throws Exception {

        Class<?> clazz = Class.forName("Student");

        Object obj = clazz.getDeclaredConstructor().newInstance();

        System.out.println("Object type: " + obj.getClass().getName());
    }
}
