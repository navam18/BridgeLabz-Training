package reflections;
import java.lang.reflect.*;
import java.util.Scanner;
class ClassInstruction{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String className=sc.nextLine();
        try{
            Class<?> c=Class.forName(className);
            Method m[]=c.getDeclaredMethods();
            for(Method method:m){
                System.out.println(method.getName());
            }
            Constructor<?> con[]=c.getDeclaredConstructors();
            for(Constructor<?> cons:con){
                System.out.println(cons.getName());
            }
            Field f[]=c.getDeclaredFields();
            for(Field field:f){
                System.out.println(field.getName());
            }
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
}