import java.util.Scanner;

class SplitCompare{
    static String[] customSplit(String s) {
        int count=1;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==' ') count++;
        }

        String[] words=new String[count];
        int j=0;
        for(int i=0;i<s.length();i++) {
            String word="";
            while(i<s.length() && s.charAt(i)!=' ') {
                word+=s.charAt(i);
                i++;
            }
            words[j]=word;
            j++;
        }
        return words;
    }

    static boolean compare(String[] a,String[] b) {
        if(a.length!=b.length) return false;
        for(int i=0;i<a.length;i++) {
            if(!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        String[] a=customSplit(st);
        String[] b=st.split(" ");
        System.out.println(compare(a,b));
    }
}
