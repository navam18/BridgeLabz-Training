import java.util.Scanner;
class SubstringCompare{
    static String substringUsingCharAt(String s,int start,int end){
        String r="";
        for(int i=start;i<end;i++){
            r+=s.charAt(i);
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
        String s=sc.next();
        System.out.println("Enter start value");
        int start=sc.nextInt();
        System.out.println("Enter end value");
        int end=sc.nextInt();
        String sub1=substringUsingCharAt(s,start,end);
        String sub2=s.substring(start,end);
        boolean result=compareUsingCharAt(sub1,sub2);
        System.out.println(sub1);
        System.out.println(sub2);
        System.out.println(result);
    }
}
