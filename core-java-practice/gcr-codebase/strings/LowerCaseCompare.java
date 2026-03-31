import java.util.Scanner;
class UpperCaseCompare{
    static String toLowerUsingCharAt(String s){
        String r="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='A'&&c<='Z') r+=(char)(c+32);
            else r+=c;
        }
        return r;
    }
    static boolean compareUsingCharAt(String s1,String s2){
        if(s1.length()!=s2.length()) return false;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter String");
        String text=sc.nextLine();
        String u1=toLowerUsingCharAt(text);
        String u2=text.toLowerCase();
        boolean result=compareUsingCharAt(u1,u2);
        System.out.println(u1);
        System.out.println(u2);
        System.out.println(result);
    }
}