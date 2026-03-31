package exceptions;
import java.util.*;
class MultipleCatch{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        try{
            int arr[]=new int[5];
            int index=sc.nextInt();
            for(int x=0;x<5;x++){
                arr[x]=sc.nextInt();
            }
            System.out.println("Index value:"+arr[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Index is out of bound");
        }
        catch(NullPointerException e){
            System.out.println("Array is null");
        }
    }
}