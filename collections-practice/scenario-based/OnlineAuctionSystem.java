import java.util.*;

class InvalidBidException extends Exception{
    InvalidBidException(String msg){
        super(msg);
    }
}

class User{
    String name;

    User(String name){
        this.name=name;
    }
}

class Bid{
    User user;
    int amount;

    Bid(User user,int amount){
        this.user=user;
        this.amount=amount;
    }
}

class AuctionItem{

    TreeMap<User,Integer> bids=new TreeMap<>(
        (u1,u2)->u1.name.compareTo(u2.name)
    );

    void placeBid(User u,int amount) throws InvalidBidException{

        if(!bids.isEmpty()){
            int highest=bids.lastEntry().getValue();
            if(amount<=highest){
                throw new InvalidBidException("Bid must be higher than current highest");
            }
        }

        bids.put(u,amount);
        System.out.println(u.name+" placed bid: "+amount);
    }

    void showHighestBid(){
        if(bids.isEmpty()){
            System.out.println("No bids yet");
            return;
        }

        Map.Entry<User,Integer> e=bids.lastEntry();
        System.out.println("Highest Bid: "+e.getKey().name+" -> "+e.getValue());
    }
}

public class OnlineAuctionSystem{
    public static void main(String args[]){

        AuctionItem item=new AuctionItem();

        User u1=new User("Ram");
        User u2=new User("Shyam");
        User u3=new User("Amit");

        try{
            item.placeBid(u1,100);
            item.placeBid(u2,150);
            item.placeBid(u3,120);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        item.showHighestBid();
    }
}
