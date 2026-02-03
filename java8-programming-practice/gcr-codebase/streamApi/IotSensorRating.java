import java.util.*;
class IotSensorRating {
    public static void main(String[] args) {
        List<Double> sensorReadings = Arrays.asList(
            22.5,
            30.2,
            18.9,
            45.6,
            27.3,
            50.1
        );
        double threshold = 25.0;
        sensorReadings.stream()
                      .filter(reading -> reading > threshold)
                      .forEach(reading ->
                          System.out.println("High Sensor Reading: " + reading)
                      );
    }
}