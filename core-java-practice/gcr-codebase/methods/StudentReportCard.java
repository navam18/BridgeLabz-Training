import java.util.Scanner;

public class StudentReportCard {

    // Method to generate random PCM scores
    static int[][] generateScores(int students) {
        int[][] scores = new int[students][3]; // Physics, Chemistry, Maths

        for (int i = 0; i < students; i++) {
            scores[i][0] = 10 + (int)(Math.random() * 90);
            scores[i][1] = 10 + (int)(Math.random() * 90);
            scores[i][2] = 10 + (int)(Math.random() * 90);
        }
        return scores;
    }

    // Method to calculate total, average, percentage, grade, remarks
    static String[][] calculateResult(int[][] scores) {
        int students = scores.length;
        String[][] result = new String[students][6];

        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            String grade, remarks;

            if (percentage >= 80) {
                grade = "A";
                remarks = "Level 4";
            } else if (percentage >= 70) {
                grade = "B";
                remarks = "Level 3";
            } else if (percentage >= 60) {
                grade = "C";
                remarks = "Level 2";
            } else if (percentage >= 50) {
                grade = "D";
                remarks = "Level 1";
            } else if (percentage >= 40) {
                grade = "E";
                remarks = "Level 1-";
            } else {
                grade = "R";
                remarks = "Remedial";
            }

            result[i][0] = String.valueOf(total);
            result[i][1] = String.valueOf(average);
            result[i][2] = String.valueOf(percentage);
            result[i][3] = grade;
            result[i][4] = remarks;
        }
        return result;
    }

    // Method to display scorecard
    static void displayScoreCard(int[][] scores, String[][] result) {
        System.out.println("Phy\tChem\tMath\tTotal\tAvg\t%\tGrade\tRemarks");

        for (int i = 0; i < scores.length; i++) {
            System.out.println(
                    scores[i][0] + "\t" +
                            scores[i][1] + "\t" +
                            scores[i][2] + "\t" +
                            result[i][0] + "\t" +
                            result[i][1] + "\t" +
                            result[i][2] + "\t" +
                            result[i][3] + "\t" +
                            result[i][4]
            );
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        int[][] scores = generateScores(students);
        String[][] result = calculateResult(scores);
        displayScoreCard(scores, result);
    }
}
