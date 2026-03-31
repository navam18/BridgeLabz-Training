
import java.util.Scanner;

abstract class GoodsTransport {

    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    // 3-argument constructor
    public GoodsTransport(String transportId, String transportDate, int transportRating) {
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    // Getters and Setters
    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    public int getTransportRating() {
        return transportRating;
    }

    public void setTransportRating(int transportRating) {
        this.transportRating = transportRating;
    }

    // Abstract methods
    public abstract String vehicleSelection();

    public abstract float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport {

    protected float brickSize;
    protected int brickQuantity;
    protected float brickPrice;

    // 6-argument constructor
    public BrickTransport(String transportId,String transportDate,int transportRating,float brickSize,
    		int brickQuantity,float brickPrice) {

        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    // Getters and Setters
    public float getBrickSize() {
        return brickSize;
    }

    public void setBrickSize(float brickSize) {
        this.brickSize = brickSize;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public void setBrickQuantity(int brickQuantity) {
        this.brickQuantity = brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    public void setBrickPrice(float brickPrice) {
        this.brickPrice = brickPrice;
    }

    // Vehicle selection logic
    @Override
    public String vehicleSelection() {

        if (brickQuantity < 300) {
            return "Truck";
        } else if (brickQuantity >= 300 && brickQuantity <= 500) {
            return "Lorry";
        } else {
            return "MonsterLorry";
        }
    }

    // Calculate total charge
    @Override
    public float calculateTotalCharge() {

        // Brick cost
        float brickCost = brickQuantity * brickPrice;

        // Vehicle price
        float vehiclePrice;
        String vehicle = vehicleSelection();

        if (vehicle.equals("Truck")) {
            vehiclePrice = 2000;
        } else if (vehicle.equals("Lorry")) {
            vehiclePrice = 4000;
        } else {
            vehiclePrice = 7000;
        }

        // Tax = 30% of brick cost
        float tax = 0.30f * brickCost;

        // Discount based on transport rating
        float discount = 0;
        if (transportRating >= 4) {
            discount = 0.10f * brickCost;
        } else if (transportRating == 3) {
            discount = 0.05f * brickCost;
        }

        // Total charge
        return brickCost + vehiclePrice + tax - discount;
    }
}

class TimberTransport extends GoodsTransport {

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius,
                           String timberType, float timberPrice) {

        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public float getTimberLength() {
        return timberLength;
    }

    public void setTimberLength(float timberLength) {
        this.timberLength = timberLength;
    }

    public float getTimberRadius() {
        return timberRadius;
    }

    public void setTimberRadius(float timberRadius) {
        this.timberRadius = timberRadius;
    }

    public String getTimberType() {
        return timberType;
    }

    public void setTimberType(String timberType) {
        this.timberType = timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    public void setTimberPrice(float timberPrice) {
        this.timberPrice = timberPrice;
    }

    @Override
    public String vehicleSelection() {

        float area = 2 * 3.147f * timberRadius * timberLength;

        if (area < 250) {
            return "Truck";
        } else if (area <= 400) {
            return "Lorry";
        } else {
            return "MonsterLorry";
        }
    }

    @Override
    public float calculateTotalCharge() {

        float volume = 3.147f * timberRadius * timberRadius * timberLength;

        float rate;
        if (timberType.equalsIgnoreCase("Premium")) {
            rate = 0.25f;
        } else {
            rate = 0.15f;
        }

        float price = volume * timberPrice * rate;
        float tax = price * 0.30f;

        float discount = 0;
        int rating = getTransportRating();

        if (rating == 5) {
            discount = price * 0.20f;
        } else if (rating == 3 || rating == 4) {
            discount = price * 0.10f;
        }

        float vehiclePrice;
        String vehicle = vehicleSelection().toLowerCase();

        if (vehicle.equals("truck")) {
            vehiclePrice = 1000;
        } else if (vehicle.equals("lorry")) {
            vehiclePrice = 1700;
        } else {
            vehiclePrice = 3000;
        }

        return price + tax + vehiclePrice - discount;
    }
}


 class Utility {

    public GoodsTransport parseDetails(String input) {
    
        String[] details = input.split(":");
        
        String id = details[0];
        String date = details[1];
        int rating = Integer.parseInt(details[2]);
        String type = details[3];

        if (type.equalsIgnoreCase("BrickTransport")) {
            float size = Float.parseFloat(details[4]);
            int quantity = Integer.parseInt(details[5]);
            float price = Float.parseFloat(details[6]);
            return new BrickTransport(id, date, rating, size, quantity, price);
        } else if (type.equalsIgnoreCase("TimberTransport")) {
            float length = Float.parseFloat(details[4]);
            float radius = Float.parseFloat(details[5]);
            String timberType = details[6];
            float price = Float.parseFloat(details[7]);
            return new TimberTransport(id, date, rating, length, radius, timberType, price);
        }
        return null;
    }

    public boolean validateTransportId(String transportId) {
        // Criteria: Starts with "RTS", followed by 3 digits (0-9), ends with uppercase A-Z
        String regex = "^RTS\\d{3}[A-Z]$";
        
        if (transportId.matches(regex)) {
            return true;
        } else {
            System.out.println("Transport Id " + transportId + " is invalid");
            System.out.println("Please provide a valid record");
            return false;
        }
    }

    public String findObjectType(GoodsTransport goodsTransport) {
        if (goodsTransport instanceof TimberTransport) {
            return "TimberTransport";
        } else if (goodsTransport instanceof BrickTransport) {
            return "BrickTransport";
        }
        return null;
    }
}


public class FutureLogistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Utility utility = new Utility();

        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();

        // Preliminary check to get the ID for validation
        String transportId = input.split(":")[0];

        if (utility.validateTransportId(transportId)) {
            GoodsTransport transport = utility.parseDetails(input);
            
            if (transport != null) {
                String type = utility.findObjectType(transport);
                float totalCharge = transport.calculateTotalCharge();

                System.out.println("Transport Id: " + transport.getTransportId());
                System.out.println("Transport Date: " + transport.getTransportDate());
                System.out.println("Transport Rating: " + transport.getTransportRating());
                System.out.println("Transport Type: " + type);
                System.out.println("Total Charge: " + totalCharge);
            }
        }
        
        sc.close();
    }
}