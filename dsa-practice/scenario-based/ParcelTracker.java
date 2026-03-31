import java.util.*;

class StageNode{
    String stage;
    StageNode next;
    StageNode(String stage){
        this.stage=stage;
        this.next=null;
    }
}

class ParcelRoute{
    StageNode head=null;

    void addStage(String stage){
        StageNode newNode=new StageNode(stage);
        if(head==null){
            head=newNode;
        }else{
            StageNode temp=head;
            while(temp.next!=null) temp=temp.next;
            temp.next=newNode;
        }
    }

    void addCheckpointAfter(String target,String newStage){
        if(head==null){
            System.out.println("No parcel route found");
            return;
        }
        StageNode temp=head;
        while(temp!=null){
            if(temp.stage.equalsIgnoreCase(target)){
                StageNode newNode=new StageNode(newStage);
                newNode.next=temp.next;
                temp.next=newNode;
                System.out.println("Checkpoint added");
                return;
            }
            temp=temp.next;
        }
        System.out.println("Stage not found");
    }

    void trackForward(){
        if(head==null){
            System.out.println("No tracking data available");
            return;
        }
        StageNode temp=head;
        while(temp!=null){
            System.out.print(temp.stage+" -> ");
            temp=temp.next;
        }
        System.out.println("END");
    }

    void handleLostParcel(){
        if(head==null){
            System.out.println("Parcel missing (null route)");
        }
    }
}

public class ParcelTracker{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ParcelRoute route=new ParcelRoute();
        route.addStage("Packed");
        route.addStage("Shipped");
        route.addStage("InTransit");
        route.addStage("Delivered");

        while(true){
            System.out.println("1.Track 2.Add Checkpoint 3.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                route.trackForward();
            }
            else if(ch==2){
                System.out.print("After which stage: ");
                String t=sc.next();
                System.out.print("New stage: ");
                String n=sc.next();
                route.addCheckpointAfter(t,n);
            }
            else{
                break;
            }
        }
    }
}
