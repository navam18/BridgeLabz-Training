import java.util.Scanner;

class TrimString {

    static int[] findRange(String s) {
        int start=0;
        int end=s.length()-1;

        while(s.charAt(start)==' ') {
            start++;
        }

        while(s.charAt(end)==' ') {
            end--;
        }

        return new int[]{start,end};
    }

    static String sub(String s,int start,int end) {
        String result="";
        for(int i=start;i<=end;i++) {
            result+=s.charAt(i);
        }
        return result;
    }

    static boolean compare(String a,String b) {
        if(a.length()!=b.length()) return false;

        for(int i=0;i<a.length();i++) {
            if(a.charAt(i)!=b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        int[] range=findRange(s);
        String trimmed=sub(s,range[0],range[1]);

        System.out.println(compare(trimmed,s.trim()));
    }
}
