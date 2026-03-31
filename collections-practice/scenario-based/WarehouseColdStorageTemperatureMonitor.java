import java.util.*;

class SensorFailureException extends Exception {
    SensorFailureException(String message) {
        super(message);
    }
}

class TemperatureLog {
    private String roomId;
    private List<Double> readings;
    private double minSafeTemp;
    private double maxSafeTemp;

    TemperatureLog(String roomId, double minSafeTemp, double maxSafeTemp) {
        this.roomId = roomId;
        this.minSafeTemp = minSafeTemp;
        this.maxSafeTemp = maxSafeTemp;
        this.readings = new ArrayList<>();
    }

    public void addReading(double temperature) throws SensorFailureException {

        if (temperature < -50 || temperature > 100) {
            throw new SensorFailureException("Sensor failure detected in Room " + roomId);
        }

        readings.add(temperature);

        if (temperature < minSafeTemp || temperature > maxSafeTemp) {
            System.out.println("ALERT! Temperature out of safe range in Room " + roomId);
        }
    }

    public double calculateDailyAverage() {

        if (readings.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;

        for (double temp : readings) {
            sum += temp;
        }

        return sum / readings.size();
    }

    public List<Double> getReadings() {
        return readings;
    }
}

class WarehouseMonitor {

    private Map<String, TemperatureLog> roomMap;

    WarehouseMonitor() {
        roomMap = new HashMap<>();
    }

    public void addRoom(String roomId, double minSafe, double maxSafe) {
        roomMap.put(roomId, new TemperatureLog(roomId, minSafe, maxSafe));
    }

    public void recordTemperature(String roomId, double temperature) {

        TemperatureLog log = roomMap.get(roomId);

        if (log == null) {
            System.out.println("Room not found");
            return;
        }

        try {
            log.addReading(temperature);
            System.out.println("Temperature recorded successfully.");
        } 
        catch (SensorFailureException e) {
            System.out.println(e.getMessage());
        }
    }

    public void showDailyAverage(String roomId) {

        TemperatureLog log = roomMap.get(roomId);

        if (log == null) {
            System.out.println("Room not found");
            return;
        }

        double avg = log.calculateDailyAverage();
        System.out.println("Daily Average Temperature of Room " + roomId + " : " + avg);
    }
}

public class WarehouseColdStorageTemperatureMonitor {

    public static void main(String[] args) {

        WarehouseMonitor monitor = new WarehouseMonitor();

        monitor.addRoom("R1", 2.0, 8.0);
        monitor.addRoom("R2", -5.0, 5.0);

        monitor.recordTemperature("R1", 5.0);
        monitor.recordTemperature("R1", 7.0);
        monitor.recordTemperature("R1", 10.0); 
        monitor.recordTemperature("R1", 150.0); 

        monitor.showDailyAverage("R1");
    }
}
