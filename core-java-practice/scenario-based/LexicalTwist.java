import java.util.Scanner;
class LexicalTwist{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first word");
        String word1=sc.nextLine();
        word1=word1.trim();
        if(word1.contains(" ")){
            System.out.println("Wrong Input:"+word1);
            return;
        }
        System.out.println("Enter second word");
        String word2=sc.nextLine();
        word2=word2.trim();
        if(word2.contains(" ")){
            System.out.println("Wrong Input:"+word2);
            return;
        }
        boolean reverse=true;
        int x=0;
        int y=word2.length()-1;
        while(x<word1.length()&&y>=0){
            if(word1.charAt(x)!=word2.charAt(y)){
                reverse=false;
                break;
            }
            x++;
            y--;
        }
        if(reverse==true){
            StringBuilder sb=new StringBuilder(word1);
            sb.reverse();
            String s=sb.toString().toLowerCase();
            String s1="";
            for(int z=0;z<s.length();z++){
                char ch=s.charAt(z);
                if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                    s1+='@';
                }
                else{
                    s1+=ch;
                }
            }
            System.out.println(s1);
        }
        else{
            String s=word1+word2;
            s=s.toUpperCase();
            int v=0;
            int c=0;
            for(int z=0;z<s.length();z++){
                char ch=s.charAt(z);
                if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                    v++;
                }
                else{
                    c++;
                }
            }
            if(v>c){
                StringBuilder sb=new StringBuilder();
                for(int z=0;z<s.length();z++){
                    char ch=s.charAt(z);
                    if((ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')){
                        if(sb.length()==0){
                            sb.append(ch);
                        }
                        else{
                            if(sb.charAt(0)!=ch){
                                sb.append(ch);
                            }
                        }
                    }
                    if(sb.length()==2)break;
                }
                System.out.println(sb.toString());
            }
            else if(v<c){
                StringBuilder sb=new StringBuilder();
                for(int z=0;z<s.length();z++){
                    char ch=s.charAt(z);
                    if(!(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U')){
                        if(sb.length()==0){
                            sb.append(ch);
                        }
                        else{
                            if(sb.charAt(0)!=ch){
                                sb.append(ch);
                            }
                        }
                    }
                    if(sb.length()==2)break;
                }
                System.out.println(sb.toString());
            }
            else{
                System.out.println("Vowels and consonants are equal.");
            }
        }
    }
}