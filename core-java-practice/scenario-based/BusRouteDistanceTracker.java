import java.util.Scanner;

class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int totalDistance=0;

        while(true){
            System.out.println("Enter distance of current stop:");
            int distance=sc.nextInt();
            totalDistance=totalDistance+distance;

            System.out.println("Total distance traveled: "+totalDistance+" km");
            System.out.println("Do you want to get off the bus? (yes/no)");
            String choice=sc.next();

            if(choice.equalsIgnoreCase("yes")){
                break;
            }
        }

        System.out.println("Passenger got off.");
        System.out.println("Final distance traveled: "+totalDistance+" km");
    }
}
