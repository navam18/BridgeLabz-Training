public class DistributePens {
    public static void main(String args[]){
        int totalPens=14;
        int people=3;
        int distributedPens=totalPens/people;
        int remaining=totalPens%people;
        System.out.println("The Pen per student is "+distributedPens+" and the remaining pen not distributed is "+remaining);
    }
}