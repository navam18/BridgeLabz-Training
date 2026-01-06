import java.util.*;
class InvalidMarkException extends Exception{
    InvalidMarkException(String m){super(m);}
}
class Student{
    String name;
    int[] marks;
    Student(String name,int[] marks){this.name=name;this.marks=marks;}
}
class ReportGenerator{
    public double average(int[] marks)throws InvalidMarkException{
        int sum=0;
        for(int m:marks){
            if(m<0||m>100)throw new InvalidMarkException("Invalid mark");
            sum+=m;
        }
        return sum/(double)marks.length;
    }
    public String grade(double avg){
        if(avg>=80)return "A";
        if(avg>=60)return "B";
        return "C";
    }
    public void display(Student s)throws Exception{
        double avg=average(s.marks);
        System.out.println(s.name+" "+String.format("%.2f",avg)+" "+grade(avg));
    }
}
public class ReportApp{
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        int students=sc.nextInt();
        int subjects=sc.nextInt();
        List<Student> list=new ArrayList<>();
        for(int i=0;i<students;i++){
            String name=sc.next();
            int[] marks=new int[subjects];
            for(int j=0;j<subjects;j++)marks[j]=sc.nextInt();
            list.add(new Student(name,marks));
        }
        ReportGenerator rg=new ReportGenerator();
        for(Student s:list)rg.display(s);
    }
}
