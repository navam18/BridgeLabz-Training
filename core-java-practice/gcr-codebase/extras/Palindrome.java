import java.util.Scanner;

class Palindrome {
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        String s=sc.next();
        boolean result=isPalindrome(s);

        if(result){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not a palindrome");
        }
    }

    static boolean isPalindrome(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
