import java.util.Scanner;
class Reverse{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int temp=num;
        int count=0;
        while(temp!=0){
            count++;
            temp/=10;
        }
        int[] digit=new int[count];
        int index=0;
        while(num!=0){
            digit[index]=num%10;
            num/=10;
            index++;
        }
        int[] reverseDigits=new int[count];
        for(int i=0;i<count;i++){
            reverseDigits[i]=digit[count-1-i];
        }
        System.out.print("Reversed number: ");
        for(int i=0;i<count;i++){
            System.out.print(reverseDigits[i]);
        }
    }
}
