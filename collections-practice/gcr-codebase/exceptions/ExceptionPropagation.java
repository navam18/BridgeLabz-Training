package exceptions;
class ExceptionPropagation{
    public static void method1(int a,int b)throws ArithmeticException{
        System.out.println("Result:"+(a/b));
    }
    public static void method2(int a,int b){
        method1(a,b);
    }
    public static void main(String args[]){
        try{
            method2(10,0);
        }
        catch(ArithmeticException e){
            System.out.println("Division by zero is not allowed");
        }
    }
}