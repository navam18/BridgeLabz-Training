public class MovieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;
    void bookTicket(String movie, String seat, double price) {
        if (isBooked) {
            System.out.println("House full!!! sorry..... Ticket already booked");
        } else {
            this.movieName = movie;
            this.seatNumber = seat;
            this.price = price;
            isBooked = true;
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }
    void display() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println();
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }
    public static void main(String[] args) {
        MovieTicket t = new MovieTicket();
        t.display();
        t.bookTicket("Dragon", "A10", 120.0);
        t.bookTicket("Dragon", "A10", 120.0);
        t.bookTicket("Dragon", "A10", 120.0);
        t.display();
    }
}
