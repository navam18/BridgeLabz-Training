import java.util.Scanner;
class SumNatural{
    static int calculateSum(int limit){
        int sum=0;
        for(int count=1;count<=limit;count++)sum+=count;
        return sum;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int limit=scanner.nextInt();
        System.out.println(calculateSum(limit));
    }
}
