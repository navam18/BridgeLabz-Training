public class StudentUniversityManagement {

    // Static variables
    static String universityName = "Global University";
    static int totalStudents = 0;

    // Instance variables
    final int rollNumber;   // final
    String name;
    String grade;

    // Constructor using this
    StudentUniversityManagement(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    // Static method
    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to update grade
    void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) {
            grade = newGrade;
            System.out.println("Grade updated to: " + grade);
        }
    }

    // Display details
    void displayDetails(Object obj) {
        if (obj instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
        }
    }

    public static void main(String[] args) {
        StudentUniversityManagement s1 = new StudentUniversityManagement(101, "Hemashree", "A");
        StudentUniversityManagement s2 = new StudentUniversityManagement(102, "Sharmila", "B");

        StudentUniversityManagement.displayTotalStudents();

        s1.displayDetails(s1);
        System.out.println();
        s2.displayDetails(s2);

        s2.updateGrade(s2, "A");
        s2.displayDetails(s2);
    }
}
