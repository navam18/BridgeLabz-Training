class Course{
    String courseName;
    int duration;
    double fee;
    static String instituteName="ABC Institute";

    Course(String courseName,int duration,double fee){
        this.courseName=courseName;
        this.duration=duration;
        this.fee=fee;
    }

    void displayCourseDetails(){
        System.out.println(courseName+" "+duration+" "+fee+" "+instituteName);
    }

    static void updateInstituteName(String name){
        instituteName=name;
    }

    public static void main(String[] args){
        Course c1=new Course("Java",60,3000);
        Course c2=new Course("Python",45,2500);
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        Course.updateInstituteName("XYZ Institute");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
