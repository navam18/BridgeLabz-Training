import java.util.Scanner;
class EduQuiz{
    static int calculateScore(String[] correct,String[] student){
        int score=0;
        for(int i=0;i<correct.length;i++){
            if(correct[i].equalsIgnoreCase(student[i])){
                score++;
            }
        }
        return score;
    }
    static void printFeedback(String[] correct,String[] student){
        for(int i=0;i<correct.length;i++){
            if(correct[i].equalsIgnoreCase(student[i])){
                System.out.println("Question "+(i+1)+": Correct");
            }else{
                System.out.println("Question "+(i+1)+": Incorrect");
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] correctAnswers={"A","B","C","D","A","B","C","D","A","B"};
        String[] studentAnswers=new String[10];
        for(int i=0;i<10;i++){
            studentAnswers[i]=sc.nextLine();
        }
        printFeedback(correctAnswers,studentAnswers);
        int score=calculateScore(correctAnswers,studentAnswers);
        double percentage=(score*100.0)/correctAnswers.length;
        System.out.println("Score: "+score);
        System.out.println("Percentage: "+percentage);
        if(percentage>=50){
            System.out.println("Pass");
        }else{
            System.out.println("Fail");
        }
    }
}