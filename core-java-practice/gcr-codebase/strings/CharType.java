import java.util.Scanner;
class CharType {
    static String type(char c) {
        if(c>='A'&&c<='Z') c=(char)(c+32);
        if(c>='a'&&c<='z') {
            if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') return "Vowel";
            return "Consonant";
        }
        return "Not a Letter";
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        for(int i=0;i<s.length();i++) {
            System.out.println(s.charAt(i)+"\t"+type(s.charAt(i)));
        }
    }
}
