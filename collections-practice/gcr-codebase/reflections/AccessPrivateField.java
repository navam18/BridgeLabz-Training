package reflections;
import java.lang.reflect.*;
class AccessPrivateField{
    private String name="Navam";
}
class Main{
    public static void main(String args[]){
        try{
            Class<?> c=Class.forName("AccessPrivateField");
            Field f=c.getDeclaredField("name");
            f.setAccessible(true);
            System.out.println("Before modification:"+f.get(c));
            f.set(c,"Sarthak");
            System.out.println("After modification:"+f.get(c));
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}