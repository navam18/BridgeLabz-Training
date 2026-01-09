package linkedList;

class TicketNode {
    int ticketId;
    String customerName;
    String movieName;
    String seatNo;
    String bookingTime;
    TicketNode next;

    TicketNode(int ticketId, String customerName, String movieName,
               String seatNo, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNo = seatNo;
        this.bookingTime = bookingTime;
    }
}

class TicketCircularList {

    private TicketNode head = null;

    public void addTicket(int id, String cust, String movie, String seat, String time) {
        TicketNode node = new TicketNode(id, cust, movie, seat, time);

        if (head == null) {
            head = node;
            node.next = head;
            return;
        }

        TicketNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = node;
        node.next = head;
    }

    public void removeTicket(int id) {
        if (head == null) return;

        if (head.ticketId == id && head.next == head) {
            head = null;
            return;
        }

        if (head.ticketId == id) {
            TicketNode last = head;
            while (last.next != head)
                last = last.next;

            head = head.next;
            last.next = head;
            return;
        }

        TicketNode temp = head;
        while (temp.next != head && temp.next.ticketId != id)
            temp = temp.next;

        if (temp.next.ticketId == id)
            temp.next = temp.next.next;
    }

    public void displayTickets() {
        if (head == null) return;

        TicketNode temp = head;
        do {
            print(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByCustomer(String name) {
        if (head == null) return;

        TicketNode temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(name))
                print(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByMovie(String movie) {
        if (head == null) return;

        TicketNode temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movie))
                print(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    private void print(TicketNode t) {
        System.out.println(t.ticketId + " | " + t.customerName + " | " +
                t.movieName + " | Seat: " + t.seatNo + " | " + t.bookingTime);
    }
}

public class TicketReservationApp {
    public static void main(String[] args) {

        TicketCircularList system = new TicketCircularList();

        system.addTicket(1, "Kapil", "Interstellar", "A1", "10:00 AM");
        system.addTicket(2, "Rahul", "Inception", "B3", "10:05 AM");
        system.addTicket(3, "Neha", "Interstellar", "C2", "10:10 AM");

        System.out.println("All Tickets:");
        system.displayTickets();

        System.out.println("\nInterstellar Tickets:");
        system.searchByMovie("Interstellar");

        system.removeTicket(2);

        System.out.println("\nAfter Cancellation:");
        system.displayTickets();

        System.out.println("\nTotal Tickets: " + system.countTickets());
    }
}
