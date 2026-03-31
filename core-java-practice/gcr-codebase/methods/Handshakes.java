import java.util.Scanner;
class Handshakes{
    static int calculateHandshakes(int numberOfStudents){
        return numberOfStudents*(numberOfStudents-1)/2;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int numberOfStudents=scanner.nextInt();
        System.out.println(calculateHandshakes(numberOfStudents));
    }
}
