import java.util.Scanner;

public class FNonRepeatChar {

    public static char findFirstNonRepeatCh(String str) {
        int[] freqArr=new int[256];
        // Count frequency
        for(int i=0; i <str.length(); i++) {
            freqArr[str.charAt(i)]++;
        }

        // Find first non-repeating character
        for(int i=0;i<str.length();i++){
            if(freqArr[str.charAt(i)]==1){
                return str.charAt(i);
            }
        }

        return '0'; // No non-repeating character
    }

    //Main method
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str=sc.nextLine();
        char res=findFirstNonRepeatCh(str);

        if(res!='0') {
            System.out.println("First non-repeating character is: " + res);
        } else {
            System.out.println("No non-repeating character found");
        }
    }
}
