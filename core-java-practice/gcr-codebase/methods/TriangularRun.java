import java.util.Scanner;
class TriangularRun{
    static double calculateRounds(double sideOne,double sideTwo,double sideThree){
        double perimeter=sideOne+sideTwo+sideThree;
        return 5000/perimeter;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        double sideOne=scanner.nextDouble();
        double sideTwo=scanner.nextDouble();
        double sideThree=scanner.nextDouble();
        System.out.println(calculateRounds(sideOne,sideTwo,sideThree));
    }
}
