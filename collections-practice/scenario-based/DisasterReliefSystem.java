import java.util.*;

public class DisasterReliefSystem {

    // AreaRequest class
    static class AreaRequest {

        String areaName;
        String resource;
        int quantity;

        AreaRequest(String areaName,String resource,int quantity){
            this.areaName=areaName;
            this.resource=resource;
            this.quantity=quantity;
        }
    }

    // ReliefCenter class
    static class ReliefCenter {

        String name;
        Map<String,Integer> resources=new HashMap<>();

        ReliefCenter(String name){
            this.name=name;
        }

        void addResource(String item,int qty){
            resources.put(item,resources.getOrDefault(item,0)+qty);
        }
    }

    // Custom Exception
    static class InsufficientResourceException extends Exception{
        InsufficientResourceException(String msg){
            super(msg);
        }
    }

    // Resource Allocator
    static class ResourceAllocator{

        Map<String,ReliefCenter> centers=new HashMap<>();
        Queue<AreaRequest> requests=new LinkedList<>();

        void addCenter(ReliefCenter rc){
            centers.put(rc.name,rc);
        }

        void addRequest(AreaRequest ar){
            requests.offer(ar);
        }

        void allocate() throws InsufficientResourceException{

            ReliefCenter rc=centers.values().iterator().next();

            while(!requests.isEmpty()){

                AreaRequest ar=requests.poll();

                int available=rc.resources.getOrDefault(ar.resource,0);

                if(available<ar.quantity){
                    throw new InsufficientResourceException("Insufficient "+ar.resource+" for "+ar.areaName);
                }

                rc.resources.put(ar.resource,available-ar.quantity);

                System.out.println(ar.areaName+" allocated "+ar.quantity+" "+ar.resource);
            }
        }
    }

    // MAIN
    public static void main(String[] args){

        try{

            ReliefCenter rc=new ReliefCenter("DelhiCenter");

            rc.addResource("Food",100);
            rc.addResource("Water",200);
            rc.addResource("Medical",50);

            ResourceAllocator allocator=new ResourceAllocator();

            allocator.addCenter(rc);

            allocator.addRequest(new AreaRequest("Area1","Food",30));
            allocator.addRequest(new AreaRequest("Area2","Water",60));
            allocator.addRequest(new AreaRequest("Area3","Medical",20));

            allocator.allocate();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
