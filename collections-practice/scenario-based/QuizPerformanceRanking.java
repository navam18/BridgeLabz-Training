import java.util.*;

class Student
{
    String name;
    String department;
    int q1;
    int q2;
    int q3;

    Student(String name,String department,int q1,int q2,int q3)
    {
        this.name=name;
        this.department=department;
        this.q1=q1;
        this.q2=q2;
        this.q3=q3;
    }

    int total()
    {
        return q1+q2+q3;
    }
}

class QuizPerformanceRanking
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        sc.nextLine();

        List<Student> list=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            String line=sc.nextLine();
            String[] p=line.split(" ");

            if(p[0].equals("Record"))
            {
                String name=p[1];
                String dept=p[2];
                int q1=Integer.parseInt(p[3]);
                int q2=Integer.parseInt(p[4]);
                int q3=Integer.parseInt(p[5]);

                list.add(new Student(name,dept,q1,q2,q3));

                System.out.println("Record Added: "+name);
            }
            else if(p[0].equals("Top"))
            {
                if(list.size()==0)
                {
                    System.out.println("No Records Available");
                    continue;
                }

                String query=p[1];

                if(query.equals("Q1"))
                {
                    int max=Integer.MIN_VALUE;

                    for(Student s:list)
                    {
                        if(s.q1>max)
                        {
                            max=s.q1;
                        }
                    }

                    for(Student s:list)
                    {
                        if(s.q1==max)
                        {
                            System.out.println(s.name+" "+max);
                        }
                    }
                }
                else if(query.equals("Q2"))
                {
                    int max=Integer.MIN_VALUE;

                    for(Student s:list)
                    {
                        if(s.q2>max)
                        {
                            max=s.q2;
                        }
                    }

                    for(Student s:list)
                    {
                        if(s.q2==max)
                        {
                            System.out.println(s.name+" "+max);
                        }
                    }
                }
                else if(query.equals("Q3"))
                {
                    int max=Integer.MIN_VALUE;

                    for(Student s:list)
                    {
                        if(s.q3>max)
                        {
                            max=s.q3;
                        }
                    }

                    for(Student s:list)
                    {
                        if(s.q3==max)
                        {
                            System.out.println(s.name+" "+max);
                        }
                    }
                }
                else
                {
                    int max=Integer.MIN_VALUE;
                    boolean found=false;

                    for(Student s:list)
                    {
                        if(s.department.equals(query))
                        {
                            found=true;
                            if(s.total()>max)
                            {
                                max=s.total();
                            }
                        }
                    }

                    if(!found)
                    {
                        System.out.println("Department Not Found");
                        continue;
                    }

                    for(Student s:list)
                    {
                        if(s.department.equals(query) && s.total()==max)
                        {
                            System.out.println(s.name+" "+max);
                        }
                    }
                }
            }
        }
    }
}