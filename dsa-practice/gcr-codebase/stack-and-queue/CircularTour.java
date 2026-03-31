import java.util.*;
//class to represent a petrol pump
class CircularTour{
    static class Pump{
        int petrol,distance;
        Pump(int p,int d){
            petrol=p;
            distance=d;
        }
    }
    //method to find starting point of circular tour
    public static int circularTour(Pump[] pumps){
        int n=pumps.length;
        int start=0,surplus=0,deficit=0;
        for(int i=0;i<n;i++){
            surplus+=pumps[i].petrol-pumps[i].distance;
            if(surplus<0){
                start=i+1;
                deficit+=surplus;
                surplus=0;
            }
        }
        return (surplus+deficit>=0)?start:-1;
    }
    //main method
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Pump[] pumps=new Pump[n];
        for(int i=0;i<n;i++){
            int p=sc.nextInt();
            int d=sc.nextInt();
            pumps[i]=new Pump(p,d);
        }
        System.out.println(circularTour(pumps));
    }
}
