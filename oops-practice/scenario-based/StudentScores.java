import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;

        while (true) {
            System.out.print("Enter the number of students: ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) break;
            } else {
                sc.next();
            }
            System.out.println("Please enter a valid positive integer.");
        }

        double[] scores = new double[n];
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                if (sc.hasNextDouble()) {
                    double score = sc.nextDouble();
                    if (score >= 0) {
                        scores[i] = score;
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("Invalid input. Please enter a non-negative number.");
            }
        }

        double sum = 0;
        double highest = scores[0];
        double lowest = scores[0];

        for (double score : scores) {
            sum += score;
            if (score > highest) highest = score;
            if (score < lowest) lowest = score;
        }

        double average = sum / n;

        System.out.println("\n--- Statistics ---");
        System.out.printf("Average Score: %.2f%n", average);
        System.out.println("Highest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);

        System.out.println("\nScores above average:");
        for (double score : scores) {
            if (score > average) {
                System.out.println(score);
            }
        }
        
        sc.close();
    }
}