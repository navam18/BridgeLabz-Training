import java.util.Scanner;

public class FreqUniqChar{

    public static char[] uniqChar(String str){
        char[] temp=new char[str.length()];
        int ind=0;
        for(int i=0;i<str.length(); i++) {
            char c=str.charAt(i);
            boolean isUniq=true;

            for(int j=0;j<i;j++){
                if(c==str.charAt(j)){
                    isUniq=false;
                    break;
                }
            }

            if(isUniq){
                temp[ind++]=c;
            }
        }

        char[] urr= new char[ind];
        for(int i=0;i<ind; i++){
            urr[i]=temp[i];
        }

        return urr;
    }
    public static String[][] freqUniq(String str) {
        int[] freq = new int[256];

        for(int i=0;i<str.length();i++){
            freq[str.charAt(i)]++;
        }
        char[] uniqueChars=uniqChar(str);
        String[][] res=new String[uniqueChars.length][2];

        for(int i = 0; i < uniqueChars.length; i++) {
            res[i][0]=String.valueOf(uniqueChars[i]);
            res[i][1]=String.valueOf(freq[uniqueChars[i]]);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[][] arr=freqUniq(text);
        System.out.println("Character  Frequency");
        for (String[] r:arr) {
            System.out.println(r[0] + "          " + r[1]);
        }

        sc.close();
    }
}
