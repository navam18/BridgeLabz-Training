import java.util.Scanner;
class SmallLarge{
    static int[] findSmallestAndLargest(int a,int b,int c){
        int s=a,l=a;
        if(b<s)s=b;
        if(c<s)s=c;
        if(b>l)l=b;
        if(c>l)l=c;
        return new int[]{s,l};
    }
    public static void main(String[] a){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        int z=sc.nextInt();
        int[] r=findSmallestAndLargest(x,y,z);
        System.out.println(r[0]+" "+r[1]);
    }
}
