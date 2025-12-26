import java.util.Scanner;
class Divide{
    static int[] findRemainderAndQuotient(int number,int divisor){
        return new int[]{number/divisor,number%divisor};
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int number=scanner.nextInt();
        int divisor=scanner.nextInt();
        int[] result=findRemainderAndQuotient(number,divisor);
        System.out.println(result[0]+" "+result[1]);
    }
}
