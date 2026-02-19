import java.util.*;

class PlatformUnavailableException extends Exception {
    PlatformUnavailableException(String message) {
        super(message);
    }
}

class Train implements Comparable<Train> {

    private String trainName;
    private int arrivalTime;
    private int departureTime;

    Train(String trainName, int arrivalTime, int departureTime) {
        this.trainName = trainName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public String getTrainName() {
        return trainName;
    }

    @Override
    public int compareTo(Train other) {
        return Integer.compare(this.arrivalTime, other.arrivalTime);
    }

    public String toString() {
        return trainName + " [Arrival: " + arrivalTime +", Departure: " + departureTime + "]";
    }
}

class Platform {

    private int platformNumber;
    private int occupiedUntil;

    Platform(int platformNumber) {
        this.platformNumber = platformNumber;
        this.occupiedUntil = 0;
    }

    public int getPlatformNumber() {
        return platformNumber;
    }

    public boolean isAvailable(int arrivalTime) {
        return arrivalTime >= occupiedUntil;
    }

    public void assignTrain(Train train) {
        occupiedUntil = train.getDepartureTime();
    }
}

class RailwayPlatformManager {

    private Map<Integer, Platform> platformMap;
    private PriorityQueue<Train> incomingTrains;

    RailwayPlatformManager() {
        platformMap = new TreeMap<>();
        incomingTrains = new PriorityQueue<>();
    }

    public void addPlatform(int platformNumber) {
        platformMap.put(platformNumber, new Platform(platformNumber));
    }

    public void addTrain(Train train) {
        incomingTrains.add(train);
    }

    public void allocatePlatforms() {

        while (!incomingTrains.isEmpty()) {

            Train train = incomingTrains.poll();
            boolean allocated = false;

            for (Platform platform : platformMap.values()) {

                if (platform.isAvailable(train.getArrivalTime())) {
                    platform.assignTrain(train);
                    System.out.println(train.getTrainName() +" allocated to Platform " +platform.getPlatformNumber());
                    allocated = true;
                    break;
                }
            }

            if (!allocated) {
                try {
                    throw new PlatformUnavailableException(
                            "No platform available for " + train.getTrainName()
                    );
                } 
                catch (PlatformUnavailableException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

public class RailwayPlatformAllocationSystem {

    public static void main(String[] args) {

        RailwayPlatformManager manager = new RailwayPlatformManager();

        manager.addPlatform(1);
        manager.addPlatform(2);

        manager.addTrain(new Train("Express-101", 10, 15));
        manager.addTrain(new Train("SuperFast-202", 12, 18));
        manager.addTrain(new Train("Local-303", 14, 20));
        manager.addTrain(new Train("Mail-404", 21, 25));

        manager.allocatePlatforms();
    }
}
