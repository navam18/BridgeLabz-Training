public class ScoreOfString {

    // Method to calculate the score
    public static int scoreOfString(String s) {
        int score = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }

        return score;
    }

    // Main method
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "zaz";

        System.out.println("Score of \"" + s1 + "\": " + scoreOfString(s1));
        System.out.println("Score of \"" + s2 + "\": " + scoreOfString(s2));
    }
}
