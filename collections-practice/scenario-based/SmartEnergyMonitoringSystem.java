import java.util.*;

class InvalidEnergyReadingException extends Exception{
    InvalidEnergyReadingException(String msg){
        super(msg);
    }
}

class EnergyMonitor{

    Map<Date,List<Double>> usage=new HashMap<>();

    void addReading(Date date,double value) throws InvalidEnergyReadingException{

        if(value<0){
            throw new InvalidEnergyReadingException("Energy reading cannot be negative");
        }

        usage.computeIfAbsent(date,k->new ArrayList<>()).add(value);
    }

    double dailyAverage(Date date){

        List<Double> list=usage.get(date);
        if(list==null){
            return 0;
        }

        double sum=0;

        for(double d:list){
            sum+=d;
        }

        return sum/list.size();
    }

    double monthlyAverage(int month){

        double total=0;
        int count=0;

        Calendar cal=Calendar.getInstance();

        for(Map.Entry<Date,List<Double>> e:usage.entrySet()){

            cal.setTime(e.getKey());

            if(cal.get(Calendar.MONTH)==month){

                for(double d:e.getValue()){
                    total+=d;
                    count++;
                }
            }
        }

        if(count==0){
            return 0;
        }

        return total/count;
    }

    void report(){

        for(Date d:usage.keySet()){
            System.out.println(d+" -> Daily Avg: "+dailyAverage(d));
        }
    }
}

public class SmartEnergyMonitoringSystem{
    public static void main(String args[]){

        EnergyMonitor em=new EnergyMonitor();

        Calendar cal=Calendar.getInstance();

        try{
            cal.set(2026,1,5);
            em.addReading(cal.getTime(),5);
            em.addReading(cal.getTime(),7);

            cal.set(2026,1,6);
            em.addReading(cal.getTime(),6);
            em.addReading(cal.getTime(),8);

            em.addReading(cal.getTime(),-3);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        em.report();

        System.out.println("Monthly Average: "+em.monthlyAverage(1));
    }
}
