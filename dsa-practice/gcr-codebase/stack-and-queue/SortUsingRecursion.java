import java.util.*;

class SortStackRecursion{
    //method to sort stack using recursion
    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int x=stack.pop();
            sortStack(stack);
            insertSorted(stack,x);
        }
    }
    //helper method to insert element in sorted order
    public static void insertSorted(Stack<Integer> stack,int x){
        if(stack.isEmpty()||stack.peek()<=x){
            stack.push(x);
            return;
        }
        int temp=stack.pop();
        insertSorted(stack,x);
        stack.push(temp);
    }
    //main method
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Stack<Integer> stack=new Stack<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            stack.push(sc.nextInt());
        }
        sortStack(stack);
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
