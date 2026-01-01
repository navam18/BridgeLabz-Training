import java.util.*;

class TextAnalyzer {

    public static int countWords(String paragraph){
        if(paragraph==null||paragraph.trim().isEmpty()) return 0;
        String[] words=paragraph.trim().split("\\s+");
        return words.length;
    }

    public static String longestWord(String paragraph){
        if(paragraph==null||paragraph.trim().isEmpty()) return "";
        String[] words=paragraph.trim().split("\\s+");
        String longest=words[0];
        for(int i=1;i<words.length;i++){
            if(words[i].length()>longest.length()){
                longest=words[i];
            }
        }
        return longest;
    }

    public static String replaceWord(String paragraph,String oldWord,String newWord){
        if(paragraph==null||paragraph.trim().isEmpty()) return paragraph;
        return paragraph.replaceAll("(?i)\\b"+oldWord+"\\b",newWord);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String paragraph=sc.nextLine();
        String oldWord=sc.next();
        String newWord=sc.next();

        System.out.println(countWords(paragraph));
        System.out.println(longestWord(paragraph));
        System.out.println(replaceWord(paragraph,oldWord,newWord));
    }
}
