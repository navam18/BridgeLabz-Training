import java.util.*;

class QueueUsingStacks{
    private Stack<Integer> s1=new Stack<>();
    private Stack<Integer> s2=new Stack<>();
    //enqueue
    public void enqueue(int x){
        s1.push(x);
    }
    //dequeue
    public int dequeue(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        //if s2 is still empty, the queue is empty
        if(s2.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return s2.pop();
    }
//check if queue is empty
    public boolean isEmpty(){
        return s1.isEmpty()&&s2.isEmpty();
    }
    //main method
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        QueueUsingStacks q=new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        q.enqueue(40);
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}
