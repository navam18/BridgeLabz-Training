import java.util.*;

class SlidingWindowMaximum{
    //method to find maximum in each sliding window of size k
    public static int[] maxSlidingWindow(int[] arr,int k){
        int n=arr.length;
        int[] res=new int[n-k+1];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty()&&dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
            while(!dq.isEmpty()&&arr[dq.peekLast()]<=arr[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
            if(i>=k-1){
                res[i-k+1]=arr[dq.peekFirst()];
            }
        }
        return res;
    }
    //main method
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] ans=maxSlidingWindow(arr,k);
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
}
