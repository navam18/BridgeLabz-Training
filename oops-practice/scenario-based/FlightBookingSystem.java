import java.util.*;

class Flight{
    int id;
    String source;
    String destination;
    int seats;
    public Flight(int id,String source,String destination,int seats){
        this.id=id;
        this.source=source;
        this.destination=destination;
        this.seats=seats;
    }
}

class Booking{
    String user;
    Flight flight;
    public Booking(String user,Flight flight){
        this.user=user;
        this.flight=flight;
    }
}

public class FlightBookingSystem{
    static Scanner sc=new Scanner(System.in);
    static Flight[] flights={
        new Flight(1,"Delhi","Mumbai",3),
        new Flight(2,"Delhi","Chennai",2),
        new Flight(3,"Mumbai","Bangalore",1)
    };
    static ArrayList<Booking> bookings=new ArrayList<>();

    public static void main(String[] args){
        while(true){
            System.out.println("1.Search 2.Book 3.ViewBookings 4.Exit");
            int ch=sc.nextInt();
            if(ch==1){
                searchFlights();
            }
            else if(ch==2){
                bookFlight();
            }
            else if(ch==3){
                showBookings();
            }
            else{
                break;
            }
        }
    }

    static void searchFlights(){
        String src=sc.next();
        String dest=sc.next();
        for(Flight f:flights){
            if(f.source.equalsIgnoreCase(src)&&f.destination.equalsIgnoreCase(dest)){
                System.out.println(f.id+" "+f.source+"-"+f.destination+" Seats:"+f.seats);
            }
        }
    }

    static void bookFlight(){
        String user=sc.next();
        int id=sc.nextInt();
        for(Flight f:flights){
            if(f.id==id&&f.seats>0){
                f.seats--;
                bookings.add(new Booking(user,f));
                System.out.println("Booked");
                return;
            }
        }
        System.out.println("Not available");
    }

    static void showBookings(){
        for(Booking b:bookings){
            System.out.println(b.user+" "+b.flight.source+"-"+b.flight.destination);
        }
    }
}
