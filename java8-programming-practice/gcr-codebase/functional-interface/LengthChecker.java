import java.util.function.Function;
class LengthChecker{
    public static void main(String args[]){
        Function<String,Integer>length=x->x.length();
        String s="Hello World";
        int len=length.apply(s);
        if(len>5){
            System.out.println("Long String");
        }
        else{
            System.out.println("Short String");
        }
    }
}