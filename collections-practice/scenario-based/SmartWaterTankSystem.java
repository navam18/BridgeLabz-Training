import java.util.*;

public class SmartWaterTankSystem {

    static class InvalidWaterLevelException extends Exception{

        InvalidWaterLevelException(String msg){
            super(msg);
        }
    }

    static class WaterTank{

        int tankId;
        double capacity;
        double currentLevel;

        WaterTank(int tankId,double capacity,double currentLevel) throws InvalidWaterLevelException{

            if(currentLevel>capacity){
                throw new InvalidWaterLevelException("Invalid level for Tank "+tankId);
            }

            this.tankId=tankId;
            this.capacity=capacity;
            this.currentLevel=currentLevel;
        }

        double usagePercentage(){
            return (currentLevel/capacity)*100;
        }
    }

    public static void main(String[] args){

        try{

            List<WaterTank> list=new ArrayList<>();

            list.add(new WaterTank(1,1000,150));
            list.add(new WaterTank(2,800,500));
            list.add(new WaterTank(3,1200,180));

            for(WaterTank t:list){

                double percent=t.usagePercentage();

                System.out.println("Tank "+t.tankId+" Usage: "+percent+"%");

                if(percent<20){
                    System.out.println("ALERT: Tank "+t.tankId+" below 20%");
                }
            }

            Collections.sort(list,new Comparator<WaterTank>(){

                public int compare(WaterTank a,WaterTank b){
                    return Double.compare(a.currentLevel,b.currentLevel);
                }
            });

            System.out.println("\nSorted by lowest water level:");

            for(WaterTank t:list){
                System.out.println("Tank "+t.tankId+" Level: "+t.currentLevel);
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
