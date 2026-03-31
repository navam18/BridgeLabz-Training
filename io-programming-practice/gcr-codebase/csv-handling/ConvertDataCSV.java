

import java.io.*;
import java.util.*;

class StudentC {
    int id;
    String name;
    int age;

    StudentC(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + " | " + name + " | " + age;
    }
}

public class ConvertDataCSV {

    public static void main(String[] args) {
        String filePath = "students.csv";
        List<StudentC> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // header
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students.add(new StudentC(
                        Integer.parseInt(data[0]),
                        data[1],
                        Integer.parseInt(data[2])
                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        students.forEach(System.out::println);
    }
}
