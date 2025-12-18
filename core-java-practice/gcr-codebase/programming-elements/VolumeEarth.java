public class VolumeEarth {
    public static void main(String args[]){
        double radius=6378;
        double km=(4/3)*3.14*radius*radius*radius;
        System.out.println("The volume of earth in cubic kilometer is "+km+" and cubic miles is "+1.6*km);
    }
}
