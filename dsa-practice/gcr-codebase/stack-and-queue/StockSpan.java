import java.util.*;

class StockSpan{
    //method to calculate stock span
    public static int[] stockSpan(int[] arr){
        int n=arr.length;
        int[] span=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty()&&arr[st.peek()]<=arr[i]){
                st.pop();
            }
            span[i]=st.isEmpty()?i+1:i-st.peek();
            st.push(i);
        }
        return span;
    }
    //main method
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int[] res=stockSpan(arr);
        for(int x:res){
            System.out.print(x+" ");
        }
    }
}
