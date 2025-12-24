import java.util.Scanner;

public class YoungerTaller {

    static int getYoungest(int[] ages){
        int minIndex=0;
        for(int i=1;i<ages.length;i++){
            if(ages[i]<ages[minIndex]){
                minIndex=i;
            }
        }
        return minIndex;
    }

    static int getTallest(int[] heights){
        int maxIndex=0;
        for(int i=1;i<heights.length;i++){
            if(heights[i]>heights[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String[] names={"Amar","Akbar","Anthony"};
        int[] ages=new int[3];
        int[] heights=new int[3];

        for(int i=0;i<3;i++){
            ages[i]=sc.nextInt();
            heights[i]=sc.nextInt();
        }

        int youngestIndex=getYoungest(ages);
        int tallestIndex=getTallest(heights);

        System.out.println(names[youngestIndex]);
        System.out.println(names[tallestIndex]);
    }
}
