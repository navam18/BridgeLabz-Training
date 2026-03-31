import java.util.Scanner;
class SecondLargest{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int maxDigit=10;
        int[] digit=new int[maxDigit];
        int index=0;
        while(num!=0){
            digit[index]=num%10;
            num=num/10;
            index++;
            if(index==maxDigit){
                break;
            }
        }
        int largest=0;
        int secondLargest=0;
        for(int i=0;i<index;i++){
            if(digit[i]>largest){
                secondLargest=largest;
                largest=digit[i];
            }
            else if(digit[i]>secondLargest&&digit[i]!=largest){
                secondLargest=digit[i];
            }
        }
        System.out.println("Largest digit: "+largest);
        System.out.println("Second Largest Digit: "+secondLargest);
    }
}
