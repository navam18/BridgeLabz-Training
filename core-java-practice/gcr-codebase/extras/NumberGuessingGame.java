import java.util.*;

class NumberGuessingGame {
    static Scanner sc=new Scanner(System.in);
    static Random rd=new Random();

    public static void main(String[] args) {
        int low=1;
        int high=100;

        while(true){
            int guess=generateGuess(low,high);
            System.out.println("Computer guess: "+guess);
            String feedback=getFeedback();

            if(feedback.equalsIgnoreCase("correct")){
                System.out.println("Computer guessed correctly");
                break;
            }
            else if(feedback.equalsIgnoreCase("low")){
                low=guess+1;
            }
            else if(feedback.equalsIgnoreCase("high")){
                high=guess-1;
            }
        }
    }

    static int generateGuess(int low,int high){
        return rd.nextInt(high-low+1)+low;
    }

    static String getFeedback(){
        System.out.println("Enter feedback (low/high/correct):");
        return sc.next();
    }
}
