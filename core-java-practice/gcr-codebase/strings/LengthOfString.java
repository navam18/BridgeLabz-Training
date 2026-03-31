import java.util.Scanner;

class LengthOfString {
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
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(getLength(s));
        System.out.println(s.length());
    }
}
