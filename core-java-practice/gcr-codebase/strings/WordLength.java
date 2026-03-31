import java.util.Scanner;

class WordLength {

    static int getLength(String s) {
        int i=0;
        try {
            while(true) {
                s.charAt(i);
                i++;
            }
        } catch(Exception e) {
        }
        return i;
    }

    static String[] customSplit(String s) {
        int count=1;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==' ') count++;
        }

        String[] words=new String[count];
        int j=0;

        for(int i=0;i<s.length();i++) {
            String word="";
            while(i<s.length()&&s.charAt(i)!=' ') {
                word+=s.charAt(i);
                i++;
            }
            words[j]=word;
            j++;
        }
        return words;
    }

    static String[][] make2D(String[] words) {
        String[][] arr=new String[words.length][2];
        for(int i=0;i<words.length;i++) {
            arr[i][0]=words[i];
            arr[i][1]=String.valueOf(getLength(words[i]));
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();

        String[] words=customSplit(s);
        String[][] data=make2D(words);

        for(int i=0;i<data.length;i++) {
            System.out.println(data[i][0]+"\t"+Integer.parseInt(data[i][1]));
        }
    }
}
