package reflections;
import java.lang.reflect.*;
public class Calculator {
    private int multiply(int a,int b){
        return a*b;
    }
}
class AccessMethod{
    public static void main(String args[]){
        try{
            Calculator c=new Calculator();
            Class<?> cls=Class.forName("reflections.Calculator");
            Method m=cls.getDeclaredMethod("multiply",int.class,int.class);
            m.setAccessible(true);
            System.out.println(m.invoke(c,5,6));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
