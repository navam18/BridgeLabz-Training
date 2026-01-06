class Student{
    public int rollNumber;
    protected String name;
    private double cgpa;

    Student(int rollNumber,String name,double cgpa){
        this.rollNumber=rollNumber;
        this.name=name;
        this.cgpa=cgpa;
    }

    public double getCgpa(){
        return cgpa;
    }

    public void setCgpa(double cgpa){
        this.cgpa=cgpa;
    }
}

class PostgraduateStudent extends Student{
    PostgraduateStudent(int rollNumber,String name,double cgpa){
        super(rollNumber,name,cgpa);
    }

    void displayDetails(){
        System.out.println(rollNumber+" "+name);
    }

    public static void main(String[] args){
        PostgraduateStudent s1=new PostgraduateStudent(101,"Ravi",8.5);
        s1.displayDetails();
        s1.setCgpa(9.0);
        System.out.println(s1.getCgpa());
    }
}
