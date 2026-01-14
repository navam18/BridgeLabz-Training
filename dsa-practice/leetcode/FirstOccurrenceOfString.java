package leetcode;
import java.util.*;
class FirstOccurrenceOfString{
    //method to find first occurrence of needle in haystack
    public int strStr(String haystack,String needle){
        return haystack.indexOf(needle);
    }
    //main method
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String haystack=sc.next();
        String needle=sc.next();
        FirstOccurrenceOfString s=new FirstOccurrenceOfString();
        System.out.println(s.strStr(haystack,needle));
    }
}
