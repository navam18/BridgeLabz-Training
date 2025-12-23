import java.util.Scanner;

public class CharFreq{

    //find the freq of the string
    public static String[][] findFreq(String str) {
        int[] arr=new int[256];
        //take freq of each char of the string
        for(int i = 0; i <str.length(); i++){
            arr[str.charAt(i)]++;
        }
        //store the char and its freq int the 2D array
        String[][] res=new String[str.length()][2];
        int ind=0;
        for(int i=0; i<256;i++){
            if(arr[i]>0){
                res[ind][0]=String.valueOf((char) i);
                res[ind][1]=String.valueOf(arr[i]);
                ind++;
            }
        }
        return res;
    }

    //main method
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter text: ");
        String str=sc.nextLine();
        String[][] arr=findFreq(str);

        System.out.println("Character  Frequency");
        for(String[] r:arr){
            if(r[0]!=null)
                System.out.println(r[0] + "          " + r[1]);
        }

        sc.close();
    }
}
