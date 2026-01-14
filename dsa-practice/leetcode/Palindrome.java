package leetcode;
import java.util.*;
class Palindrome{
    //method to check if integer is palindrome
    public boolean isPalindrome(int x){
        int r=0,t=x;
        if(x>=0){
            while(x!=0){
                int d=x%10;
                r=r*10+d;
                x=x/10;
            }
            return r==t;
        }
        return false;
    }
    //main method
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        Palindrome s=new Palindrome();
        System.out.println(s.isPalindrome(x));
    }
}
