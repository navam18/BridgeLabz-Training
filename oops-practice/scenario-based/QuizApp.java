import java.util.*;
class InvalidQuizSubmissionException extends Exception{
    InvalidQuizSubmissionException(String m){super(m);}
}
class QuizProcessor{
    public int calculateScore(String[] correct,String[] user)throws InvalidQuizSubmissionException{
        if(correct.length!=user.length)throw new InvalidQuizSubmissionException("Length mismatch");
        int score=0;
        for(int i=0;i<correct.length;i++)if(correct[i].equalsIgnoreCase(user[i]))score++;
        return score;
    }
    public String grade(int score){
        if(score>=8)return "A";
        if(score>=5)return "B";
        return "C";
    }
}
public class QuizApp{
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] correct=new String[n];
        String[] user=new String[n];
        for(int i=0;i<n;i++)correct[i]=sc.next();
        for(int i=0;i<n;i++)user[i]=sc.next();
        QuizProcessor qp=new QuizProcessor();
        List<Integer> scores=new ArrayList<>();
        int score=qp.calculateScore(correct,user);
        scores.add(score);
        System.out.println(score+" "+qp.grade(score));
    }
}
