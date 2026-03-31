import java.util.Scanner;

class Voting {
    static int[] ages(int n) {
        int[] a=new int[n];
        for(int i=0;i<n;i++) {
            a[i]=(int)(Math.random()*90);
        }
        return a;
    }

    static String[][] check(int[] a) {
        String[][] res=new String[a.length][2];
        for(int i=0;i<a.length;i++) {
            res[i][0]=String.valueOf(a[i]);
            if(a[i]>=18) res[i][1]="true";
            else res[i][1]="false";
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=10;
        int[] a=ages(n);
        String[][] r=check(a);

        for(int i=0;i<n;i++) {
            System.out.println(r[i][0]+"\t"+r[i][1]);
        }
    }
}
