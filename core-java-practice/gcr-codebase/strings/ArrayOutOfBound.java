import java.util.Scanner;
class ArrayOutOfBound{
    static void generateException(String[] a){
        System.out.println(a[a.length]);
    }
    static void handleException(String[] a){
        try{
            System.out.println(a[a.length]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException handled");
        }catch(RuntimeException e){
            System.out.println("RuntimeException handled");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] a=new String[n];
        for(int i=0;i<n;i++){
            a[i]=sc.next();
        }
        try{
            generateException(a);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception generated");
        }
        handleException(a);
    }
}
