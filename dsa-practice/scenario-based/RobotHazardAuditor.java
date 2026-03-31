import java.util.*;
class RobotSafetyException extends Exception{
    public RobotSafetyException(String message){
        super(message);
    }
}
class RobotHazardAuditor{
    public static void main(String args[]){
        Scanner sc=new  Scanner(System.in);
        try{
            System.out.println("Enter Arm Precision (0.0-1.0):");
            double armPrecision=sc.nextDouble();
            System.out.println("Enter Work Density (1-20):");
            int workDensity=sc.nextInt();
            System.out.println("Enter Machinery State(Worn/Faulty/Critical):");
            String machineryState=sc.next();
            System.out.println("Robot Hazard Risk Score :"+calculateHazardRisk(armPrecision, workDensity, machineryState));
        }
        catch(RobotSafetyException e){
            System.out.println(e.getMessage());
        }
    }
    public static double calculateHazardRisk(double armPrecision,int workDensity,String machineryState)throws RobotSafetyException{
        if(armPrecision<0.0||armPrecision>1.0){
            throw new RobotSafetyException("Error: Arm Precision must be 0.0-1.0");
        }
        if(workDensity<1||workDensity>20){
            throw new RobotSafetyException("Error: Work Density must be 1-20");
        }
        double hazardRisk=0.0;
        if(machineryState.equals("Worn")){
            hazardRisk=((1.0-armPrecision)*15.0)+workDensity*1.3;
        }
        else if(machineryState.equals("Faulty")){
            hazardRisk=((1.0-armPrecision)*15.0)+workDensity*2.0;
        }
        else if(machineryState.equals("Critical")){
            hazardRisk=((1.0-armPrecision)*15.0)+workDensity*3.0;
        }
        else{
            throw new RobotSafetyException("Error: Unsupported machinery state");
        }
        return hazardRisk;
    }
}