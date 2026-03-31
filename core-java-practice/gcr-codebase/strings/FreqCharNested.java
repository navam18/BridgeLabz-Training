import java.util.Scanner;

public class FreqCharNested{
    public static String[] findFreq(String str){
        char[] crr=str.toCharArray();
        int[] freq=new int[crr.length];
        for(int i=0;i<crr.length;i++){
            if(crr[i]=='0') continue;
            freq[i]=1;
            for(int j=i+1;j<crr.length;j++){
                if (crr[i]==crr[j]){
                    freq[i]++;
                    crr[j] = '0';
                }
            }
        }

        String[] res=new String[crr.length];
        int ind=0;

        for(int i=0;i<crr.length; i++){
            if(crr[i]!='0'){
                res[ind++]=crr[i] + ":" + freq[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String[] out=findFreq(str);
        for(String s:out){
            if(s!=null) System.out.println(s);
        }
    }
}
