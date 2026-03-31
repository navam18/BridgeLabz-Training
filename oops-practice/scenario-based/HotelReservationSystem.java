import java.util.*;

class RoomNotAvailableException extends Exception {
    public RoomNotAvailableException(String msg) {
        super(msg);
    }
}

interface PricingStrategy {
    double calculatePrice(double basePrice);
}

class SeasonalPricing implements PricingStrategy {
    public double calculatePrice(double basePrice) {
        return basePrice * 1.2; // 20% seasonal hike
    }
}

abstract class Room {
    int roomNo;
    double price;
    boolean isAvailable = true;

    Room(int no, double price) {
        this.roomNo = no;
        this.price = price;
    }

    abstract double getFinalPrice(PricingStrategy strategy);
}

class StandardRoom extends Room {
    StandardRoom(int no, double price) {
        super(no, price);
    }

    double getFinalPrice(PricingStrategy strategy) {
        return strategy.calculatePrice(price);
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int no, double price) {
        super(no, price);
    }

    double getFinalPrice(PricingStrategy strategy) {
        return strategy.calculatePrice(price + 2000);
    }
}


class Guest {
    int guestId;
    String name;

    Guest(int id, String name) {
        guestId = id;
        this.name = name;
    }
}

class Reservation {
    Guest guest;
    Room room;

    Reservation(Guest g, Room r) {
        guest = g;
        room = r;
    }
}


public class HotelReservationSystem {
    public static void main(String[] args) {

        Room room1 = new StandardRoom(101, 3000);
        Room room2 = new DeluxeRoom(102, 5000);

        Guest g1 = new Guest(1, "Ravi");
        PricingStrategy pricing = new SeasonalPricing();

        try {
            bookRoom(room2, g1, pricing);
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }

    static void bookRoom(Room room, Guest guest, PricingStrategy pricing)
            throws RoomNotAvailableException {

        if (!room.isAvailable)
            throw new RoomNotAvailableException("Room not available");

        room.isAvailable = false;
        double bill = room.getFinalPrice(pricing);

        System.out.println("Guest: " + guest.name);
        System.out.println("Room No: " + room.roomNo);
        System.out.println("Total Bill: ₹" + bill);
        System.out.println("Checked in successfully");
    }
}

