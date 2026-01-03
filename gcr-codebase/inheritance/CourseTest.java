class Course {
    String courseName;
    int duration;
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;
}

public class CourseTest {
    public static void main(String[] args) {
        PaidOnlineCourse course = new PaidOnlineCourse();
        course.courseName = "DSA";
        course.duration = 3;
        course.platform = "Udemy";
        course.fee = 5000;
        course.discount = 10;

        System.out.println("Course: " + course.courseName);
    }
}
