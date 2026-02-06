import java.util.*;
import java.util.stream.*;

class Student {

    String name;
    String grade;

    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }

    String getName() {
        return name;
    }

    String getGrade() {
        return grade;
    }
}

public class GroupingBy {

    public static void main(String args[]) {

        List<Student> list = Arrays.asList(
                new Student("Rahul", "A"),
                new Student("Ankit", "A"),
                new Student("Neha", "B"),
                new Student("Priya", "B"),
                new Student("Aman", "C")
        );

        Map<String, List<String>> result =
                list.stream()
                    .collect(Collectors.groupingBy(
                            Student::getGrade,
                            Collectors.mapping(Student::getName, Collectors.toList())
                    ));

        System.out.println(result);
    }
}
