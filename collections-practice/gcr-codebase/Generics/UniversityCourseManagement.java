import java.util.*;
abstract class CourseType {
    abstract String getEvaluationType();
    abstract int getCredits();
}
class ExamCourse extends CourseType {

    @Override
    String getEvaluationType() {
        return "Exam Based";
    }

    @Override
    int getCredits() {
        return 4;
    }
}
class AssignmentCourse extends CourseType {

    @Override
    String getEvaluationType() {
        return "Assignment Based";
    }

    @Override
    int getCredits() {
        return 3;
    }
}
class ResearchCourse extends CourseType {

    @Override
    String getEvaluationType() {
        return "Research Based";
    }

    @Override
    int getCredits() {
        return 6;
    }
}
class Course<T extends CourseType> {

    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public void showCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Evaluation: " + courseType.getEvaluationType());
        System.out.println("Credits: " + courseType.getCredits());
        System.out.println("--------------------------------");
    }

    public T getCourseType() {
        return courseType;
    }
}


class CourseManager {

    public static void displayAllCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(
                    "Evaluation Type: " + course.getEvaluationType() +
                            ", Credits: " + course.getCredits()
            );
        }
    }
}

public class UniversityCourseManagement {
    public static void main(String[] args) {
        Course<ExamCourse> math = new Course<>("Mathematics", new ExamCourse());

        Course<AssignmentCourse> history = new Course<>("History", new AssignmentCourse());

        Course<ResearchCourse> phdAI = new Course<>("AI Research", new ResearchCourse());

        math.showCourseDetails();
        history.showCourseDetails();
        phdAI.showCourseDetails();

        List<CourseType> allCourseTypes = Arrays.asList(
                new ExamCourse(),
                new AssignmentCourse(),
                new ResearchCourse()
        );
        CourseManager.displayAllCourses(allCourseTypes);
    }
}
