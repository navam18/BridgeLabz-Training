import java.util.*;

class TextFormatter {
    public static String formatParagraph(String paragraph) {
        paragraph=paragraph.trim().replaceAll("\\s+"," ");
        StringBuilder result=new StringBuilder();
        boolean capitalize=true;

        for(int i=0;i<paragraph.length();i++){
            char ch=paragraph.charAt(i);

            if(ch=='.'||ch=='?'||ch=='!'){
                result.append(ch);
                if(i+1<paragraph.length()&&paragraph.charAt(i+1)!=' '){
                    result.append(' ');
                }
                capitalize=true;
            }
            else if(ch==' '){
                result.append(ch);
            }
            else{
                if(capitalize){
                    result.append(Character.toUpperCase(ch));
                    capitalize=false;
                }
                else{
                    result.append(ch);
                }
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String paragraph=sc.nextLine();
        System.out.println(formatParagraph(paragraph));
    }
}
