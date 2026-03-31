import java.util.Scanner;
public class StudentGradeCode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Physics marks: ");
        int phy=sc.nextInt();
        System.out.print("Enter Chemistry marks: ");
        int chem= sc.nextInt();
        System.out.print("Enter Maths marks: ");
        int maths=sc.nextInt();
        double avg=(phy+chem+maths)/3.0;
        System.out.println("Average Marks: "+avg);
        if(avg>=90){
            System.out.println("Grade: A");
            System.out.println("Remarks: Excellent");
        }else if(avg>=75){
            System.out.println("Grade: B");
            System.out.println("Remarks: Very Good");
        }else if(avg>=60){
            System.out.println("Grade: C");
            System.out.println("Remarks: Good");
        }else if(avg>=40){
            System.out.println("Grade: D");
            System.out.println("Remarks: Pass");
        } else{
            System.out.println("Grade: F");
            System.out.println("Remarks: Fail");
        }
    }
}
