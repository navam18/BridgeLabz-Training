import java.util.Scanner;
class MaxElementArray{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]={1,5,6,8,3};
        int max=0;
        for(int x=0;x<arr.length;x++){
            max=Math.max(max,arr[x]);
        }
        System.out.println(max);
    }
}