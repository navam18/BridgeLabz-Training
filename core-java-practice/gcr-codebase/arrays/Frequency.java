import java.util.Scanner;
class Frequency{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        int temp=num;
        int count=0;
        while(temp!=0){
            count++;
            temp=temp/10;
        }
        int[] digit=new int[count];
        int index=0;
        while(num!=0){
            digit[index]=num%10;
            num=num/10;
            index++;
        }
        int[] freq=new int[10];
        for(int i=0;i<count;i++){
            freq[digit[i]]++;
        }
        for(int i=0;i<10;i++){
            if(freq[i]>0){
                System.out.println("Digit "+i+" occurs "+freq[i]+" times");
            }
        }
    }
}
