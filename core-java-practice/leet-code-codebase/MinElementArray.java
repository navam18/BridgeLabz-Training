import java.util.Scanner;
class MinElementArray{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]={1,5,6,8,3};
        int min=arr[0];
        for(int x=0;x<arr.length;x++){
            min=Math.min(min,arr[x]);
        }
        System.out.println(min);
    }
}