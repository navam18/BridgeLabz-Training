import java.util.*;

class Vessel{
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    Vessel(){
        this.vesselId = "";
        this.vesselName = "";
        this.averageSpeed = 0.0;
        this.vesselType = "";
    }

    Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType){
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    public String getVesselName(){
        return vesselName;
    }
    public String getVesselId(){
        return vesselId;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public String getVesselType() {
        return vesselType;
    }


}

class VesselUtil{
    private List<Vessel> vesselList = new ArrayList<>();

    public void addVesselPerformance(Vessel vessel){
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId){
        for(Vessel v : vesselList){
            String id = v.getVesselId();
            if(id.equals(vesselId)){
                return v;
            }
        }

        return null;
    }

    public List<Vessel> getHighPerformanceVessels(){
        List<Vessel> vessels = new ArrayList<>();

        double highestSpeed = 0.0;

        for(Vessel v : vesselList){
            if(v.getAverageSpeed() > highestSpeed){
                highestSpeed = v.getAverageSpeed();
            }
        }

        for(Vessel v : vesselList){
            if(v.getAverageSpeed() == highestSpeed){
                vessels.add(v);
            }
        }


        return vessels;

        
    }


}

class OceanFleet{
    public static void main(String[] args) {
        VesselUtil vesselUtil = new VesselUtil();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vessels to be added");
        int count = sc.nextInt();

        System.out.println("Enter vessel details");
        
        sc.nextLine(); 
        for(int i = 0; i < count; i++){
            String input = sc.nextLine();
            String[] data = input.split(":");
            vesselUtil.addVesselPerformance(new Vessel(data[0], data[1],Double.parseDouble(data[2]), data[3]));
        }

        System.out.println("Enter the Vessel Id to check speed");
        String id = sc.next();

        Vessel found_vessel = vesselUtil.getVesselById(id);

        if(found_vessel != null){
            System.out.println(found_vessel.getVesselId()+" | " + found_vessel.getVesselName() + " | " + found_vessel.getVesselType() + " | " + found_vessel.getAverageSpeed());
        }
        else{
            System.out.println("Vessel Id "+ id + " not found");
        }

        List<Vessel> performanceVessels = vesselUtil.getHighPerformanceVessels();

        System.out.println("High Performance Vessels are");
        for(Vessel v : performanceVessels){
            System.out.println(v.getVesselId()+" | " + v.getVesselName() + " | " + v.getVesselType() + " | " + v.getAverageSpeed());
        }

        sc.close();
    }
}