import java.util.Scanner;

class ShortLong {
    static int getLength(String s) {
        int i=0;
        try {
            while(true) {
                s.charAt(i);
                i++;
            }
        } catch(Exception e) {
        }
        return i;
    }

    static String[] customSplit(String s) {
        int cnt=1;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==' ') cnt++;
        }

        String[] words=new String[cnt];
        int start=0,index=0;

        for(int i=0;i<=s.length();i++) {
            if(i==s.length()||s.charAt(i)==' ') {
                words[index++]=s.substring(start,i);
                start=i+1;
            }
        }
        return words;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        String[] w=customSplit(s);

        String small=w[0],large=w[0];

        for(int i=1;i<w.length;i++) {
            if(getLength(w[i])<getLength(small)) small=w[i];
            if(getLength(w[i])>getLength(large)) large=w[i];
        }

        System.out.println("Shortest:"+small);
        System.out.println("Longest:"+large);
    }
}
