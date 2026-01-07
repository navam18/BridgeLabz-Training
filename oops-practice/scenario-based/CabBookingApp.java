import java.util.*;
interface FareCalculator {
    double calculateFare(double distance);
}
class NormalFareCalculator implements FareCalculator{
    @Override
    public double calculateFare(double distance) {
        return distance*10;
    }
}
class PeakFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15; // ₹15 per km (peak hours)
    }
}

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

class User{
    private int uId;
    private String name;
    public User(int uId, String name){
        this.uId=uId;
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
class Driver {
    private int driverId;
    private String name;
    private boolean available;

    public Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assignDriver() {
        available = false;
    }

    public void releaseDriver() {
        available = true;
    }

    public String getName() {
        return name;
    }
}
class Ride{
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, double distance, FareCalculator fareCalculator){
        this.driver=driver;
        this.user=user;
        this.distance=distance;
        this.fare=fareCalculator.calculateFare(distance);
    }

    public void displayRideDetails() {
        System.out.println("User: " + user.getName());
        System.out.println("Driver: " + driver.getName());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Fare: ₹" + fare);
        System.out.println("-----------------------------");
    }
}
class RideService {

    private List<Driver> drivers = new ArrayList<>();
    private List<Ride> rideHistory = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    private Driver assignDriver() throws NoDriverAvailableException {
        for (Driver d : drivers) {
            if (d.isAvailable()) {
                d.assignDriver();
                return d;
            }
        }
        throw new NoDriverAvailableException("No drivers available at the moment.");
    }

    public void bookRide(User user, double distance, boolean isPeakHour)
            throws NoDriverAvailableException {

        Driver driver = assignDriver();

        FareCalculator calculator;
        if (isPeakHour) {
            calculator = new PeakFareCalculator();
        } else {
            calculator = new NormalFareCalculator();
        }

        Ride ride = new Ride(user, driver, distance, calculator);
        rideHistory.add(ride);

        System.out.println("Ride Booked Successfully!");
        ride.displayRideDetails();

        driver.releaseDriver(); // Ride completed
    }

    public void showRideHistory() {
        System.out.println("\n=== Ride History ===");
        for (Ride r : rideHistory) {
            r.displayRideDetails();
        }
    }
}

public class CabBookingApp {
    public static void main(String[] args) {
        RideService service = new RideService();
        // Add drivers
        service.addDriver(new Driver(1, "Ramesh"));
        service.addDriver(new Driver(2, "Suresh"));
        // Users
        User user1 = new User(101, "Divyansh");
        User user2 = new User(102, "Rohan");

        try {
            service.bookRide(user1, 12.5, false); // Normal pricing
            service.bookRide(user2, 8.0, true);   // Peak pricing
        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }
        service.showRideHistory();
    }
}

