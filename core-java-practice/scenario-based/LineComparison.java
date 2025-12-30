import java.util.Scanner;

public class LineComparison {

    // Method to calculate line length using distance formula
    private static double calculateLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Line Comparison Computation Program on Master Branch\n");

        Scanner sc = new Scanner(System.in);

        //UC1: MODEL A LINE & CALCULATE LENGTH
        System.out.println("UC1: Enter coordinates for Line 1");

        System.out.print("Enter x1: ");
        int x1 = sc.nextInt();
        System.out.print("Enter y1: ");
        int y1 = sc.nextInt();
        System.out.print("Enter x2: ");
        int x2 = sc.nextInt();
        System.out.print("Enter y2: ");
        int y2 = sc.nextInt();

        double line1Length = calculateLength(x1, y1, x2, y2);
        System.out.println("Length of Line 1 = " + line1Length + "\n");

        //UC2: CHECK EQUALITY OF TWO LINES
        System.out.println("UC2: Enter coordinates for Line 2");

        System.out.print("Enter x1: ");
        int a1 = sc.nextInt();
        System.out.print("Enter y1: ");
        int b1 = sc.nextInt();
        System.out.print("Enter x2: ");
        int a2 = sc.nextInt();
        System.out.print("Enter y2: ");
        int b2 = sc.nextInt();

        double line2Length = calculateLength(a1, b1, a2, b2);
        System.out.println("Length of Line 2 = " + line2Length + "\n");

        // Using equals() method to check if both line lengths are equal
        System.out.println("UC2: Checking equality using equals()...");
        if (Double.valueOf(line1Length).equals(line2Length)) {
            System.out.println("Both lines are EQUAL in length.\n");
        } else {
            System.out.println("Lines are NOT equal in length.\n");
        }

        //UC3: COMPARE TWO LINES
        System.out.println("UC3: Comparing two lines using compareTo()...");

        int comparison = Double.valueOf(line1Length).compareTo(line2Length);

        if (comparison == 0) {
            System.out.println("Line 1 is EQUAL to Line 2");
        } else if (comparison > 0) {
            System.out.println("Line 1 is GREATER than Line 2");
        } else {
            System.out.println("Line 1 is LESS than Line 2");
        }
    }
}
