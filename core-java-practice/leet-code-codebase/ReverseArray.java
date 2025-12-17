import java.util.Scanner;
class ReverseArray{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int arr[]={5,4,3,2,1};
        int l=0;
        int r=arr.length-1;
        while(l<r){
            int t=arr[l];
            arr[l]=arr[r];
            arr[r]=t;
            l++;
            r--;
        }
        for(int x=0;x<arr.length;x++){
            System.out.print(arr[x]+" ");
        }
    }
}