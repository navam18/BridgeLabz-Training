import java.util.*;
class InvalidRatingException extends Exception{
    InvalidRatingException(String msg){
        super(msg);
    }
}
class Event{
    String eventId;
    List<Integer>ratings;
    Event(String eventId){
        this.eventId=eventId;
        ratings=new ArrayList<>();
    }
    void addRating(int rating)throws InvalidRatingException{
        if(rating<1||rating>5){
            throw new InvalidRatingException("Rating must be between 1 and 5");
        }
        ratings.add(rating);
    }
    double getAverage(){
        int sum=0;
        for(int r:ratings){
            sum=sum+r;
        }
        return (double)sum/ratings.size();
    }
}
class EventFeedbackAnalyzer{
    public static void main(String args[]){
        try{
            Map<String,Event>map=new HashMap<>();
            map.put("E101",new Event("E101"));
            map.put("E102",new Event("E102"));
            map.put("E103",new Event("E103"));
            map.get("E101").addRating(5);
            map.get("E101").addRating(4);
            map.get("E102").addRating(3);
            map.get("E102").addRating(4);
            map.get("E103").addRating(5);
            map.get("E103").addRating(5);
            String top="";
            double max=0;
            for(String id:map.keySet()){
                double avg=map.get(id).getAverage();
                System.out.println(id+" "+avg);
                if(avg>max){
                    max=avg;
                    top=id;
                }
            }
            System.out.println("Top Event: "+top+" "+max);
        }
        catch(InvalidRatingException e){
            System.out.println(e.getMessage());
        }
    }
}
