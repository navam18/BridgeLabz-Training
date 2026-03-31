import java.util.*;

class InvalidFlightException extends Exception {

    public InvalidFlightException(String message) {
        super(message);
    }
}

class FlightUtil {

    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {

        if (!flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
        }

        return true;
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {

        if (!(flightName.equalsIgnoreCase("SpiceJet") ||
                flightName.equalsIgnoreCase("Vistara") ||
                flightName.equalsIgnoreCase("IndiGo") ||
                flightName.equalsIgnoreCase("Air Arabia"))) {

            throw new InvalidFlightException("The flight name " + flightName + " is invalid");
        }

        return true;
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {

        Map<String, Integer> capacity = new HashMap<>();
        capacity.put("SpiceJet", 396);
        capacity.put("Vistara", 615);
        capacity.put("IndiGo", 230);
        capacity.put("Air Arabia", 130);

        int max = capacity.get(flightName);

        if (passengerCount <= 0 || passengerCount > max) {
            throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
        }

        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {

        Map<String, Double> fuel = new HashMap<>();
        fuel.put("SpiceJet", 200000.0);
        fuel.put("Vistara", 300000.0);
        fuel.put("IndiGo", 250000.0);
        fuel.put("Air Arabia", 150000.0);

        double maxFuel = fuel.get(flightName);

        if (currentFuelLevel < 0 || currentFuelLevel > maxFuel) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }

        return maxFuel - currentFuelLevel;
    }
}

public class AeroVigil {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FlightUtil util = new FlightUtil();

        System.out.println("Enter flight details");

        try {

            String input = sc.nextLine();

            String[] data = input.split(":");

            String flightNumber = data[0];
            String flightName = data[1];
            int passengerCount = Integer.parseInt(data[2]);
            double fuelLevel = Double.parseDouble(data[3]);

            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount, flightName);

            double fuelRequired = util.calculateFuelToFillTank(flightName, fuelLevel);

            System.out.println("Fuel required to fill the tank: " + fuelRequired + " liters");

        } catch (InvalidFlightException e) {

            System.out.println(e.getMessage());

        } catch (Exception e) {

            System.out.println("Invalid input");

        }

        sc.close();
    }
}
