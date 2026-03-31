import java.util.Scanner;
class Chocolates{
    static int[] findRemainderAndQuotient(int chocolates,int children){
        return new int[]{chocolates/children,chocolates%children};
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int chocolates=scanner.nextInt();
        int children=scanner.nextInt();
        int[] result=findRemainderAndQuotient(chocolates,children);
        System.out.println(result[0]+" "+result[1]);
    }
}
