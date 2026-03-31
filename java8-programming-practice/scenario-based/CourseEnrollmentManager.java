import java.util.*;
import java.util.stream.*;
import java.time.*;

class Enrollment{

    String studentName;
    String courseName;
    String category;
    LocalDate date;

    Enrollment(String s,String c,String cat,LocalDate d){
        studentName=s;
        courseName=c;
        category=cat;
        date=d;
    }

    public String toString(){
        return studentName+" | "+courseName+" | "+category+" | "+date;
    }

    String getCourseName(){
        return courseName;
    }

    String getCategory(){
        return category;
    }

    LocalDate getDate(){
        return date;
    }
}

public class CourseEnrollmentManager{

    public static void main(String args[]){

        List<Enrollment> list=new ArrayList<>();

        list.add(new Enrollment("Amit","Java","Programming",LocalDate.of(2025,1,10)));
        list.add(new Enrollment("Rahul","Python","Programming",LocalDate.of(2025,1,12)));
        list.add(new Enrollment("Neha","AWS","Cloud",LocalDate.of(2025,1,5)));
        list.add(new Enrollment("Priya","Java","Programming",LocalDate.of(2025,1,8)));
        list.add(new Enrollment("Karan","Azure","Cloud",LocalDate.of(2025,1,15)));

        System.out.println("\n--- Filter by Course (Java) ---");
        list.stream()
            .filter(e->e.courseName.equals("Java"))
            .forEach(System.out::println);

        System.out.println("\n--- Filter by Category (Cloud) ---");
        list.stream()
            .filter(e->e.category.equals("Cloud"))
            .forEach(System.out::println);

        System.out.println("\n--- Group By Course ---");
        Map<String,List<Enrollment>> groupCourse=
                list.stream().collect(Collectors.groupingBy(Enrollment::getCourseName));
        System.out.println(groupCourse);

        System.out.println("\n--- Count Enrollment per Category ---");
        Map<String,Long> countCategory=
                list.stream().collect(Collectors.groupingBy(Enrollment::getCategory,Collectors.counting()));
        System.out.println(countCategory);

        System.out.println("\n--- Sort by Enrollment Date ---");
        list.stream()
            .sorted(Comparator.comparing(Enrollment::getDate))
            .forEach(System.out::println);
    }
}
