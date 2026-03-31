import java.util.*;

class VehicleNode{
    String number;
    VehicleNode next;
    VehicleNode(String number){
        this.number=number;
        this.next=null;
    }
}

class Roundabout{
    VehicleNode head=null;
    void addVehicle(String num){
        VehicleNode newNode=new VehicleNode(num);
        if(head==null){
            head=newNode;
            newNode.next=head;
        }else{
            VehicleNode temp=head;
            while(temp.next!=head) temp=temp.next;
            temp.next=newNode;
            newNode.next=head;
        }
    }
    void removeVehicle(String num){
        if(head==null){
            System.out.println("Roundabout empty");
            return;
        }
        VehicleNode curr=head,prev=null;
        do{
            if(curr.number.equals(num)){
                if(curr==head && curr.next==head){
                    head=null;
                }else{
                    if(curr==head){
                        VehicleNode last=head;
                        while(last.next!=head) last=last.next;
                        head=head.next;
                        last.next=head;
                    }else{
                        prev.next=curr.next;
                    }
                }
                System.out.println("Vehicle removed");
                return;
            }
            prev=curr;
            curr=curr.next;
        }while(curr!=head);
        System.out.println("Vehicle not found");
    }
    void display(){
        if(head==null){
            System.out.println("No vehicles in roundabout");
            return;
        }
        VehicleNode temp=head;
        do{
            System.out.print(temp.number+" -> ");
            temp=temp.next;
        }while(temp!=head);
        System.out.println("(back to start)");
    }
}

class WaitingQueue{
    Queue<String> q=new LinkedList<>();
    int capacity=5;
    void enqueue(String v){
        if(q.size()==capacity){
            System.out.println("Queue Overflow");
        }else{
            q.add(v);
            System.out.println("Vehicle added to waiting queue");
        }
    }
    String dequeue(){
        if(q.isEmpty()){
            System.out.println("Queue Underflow");
            return null;
        }
        return q.poll();
    }
}

public class TrafficManager{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Roundabout r=new Roundabout();
        WaitingQueue w=new WaitingQueue();
        while(true){
            System.out.println("1.Enter Queue 2.Move to Roundabout 3.Exit Roundabout 4.Display 5.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("Vehicle number: ");
                w.enqueue(sc.next());
            }
            else if(ch==2){
                String v=w.dequeue();
                if(v!=null) r.addVehicle(v);
            }
            else if(ch==3){
                System.out.print("Vehicle number: ");
                r.removeVehicle(sc.next());
            }
            else if(ch==4){
                r.display();
            }
            else break;
        }
    }
}
