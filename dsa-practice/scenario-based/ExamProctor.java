import java.util.*;

class ExamSession{
    Stack<Integer> navigation=new Stack<>();
    Map<Integer,String> answers=new HashMap<>();

    void visitQuestion(int qid){
        navigation.push(qid);
        System.out.println("Visited Question "+qid);
    }

    void answerQuestion(int qid,String ans){
        answers.put(qid,ans);
        System.out.println("Answer saved");
    }
}

public class ExamProctor{
    static int evaluate(Map<Integer,String> ans){
        Map<Integer,String> correct=new HashMap<>();
        correct.put(1,"A");
        correct.put(2,"C");
        correct.put(3,"B");
        int score=0;
        for(int q:correct.keySet()){
            if(correct.get(q).equals(ans.get(q))){
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ExamSession session=new ExamSession();

        while(true){
            System.out.println("1.Visit 2.Answer 3.Back 4.Submit");
            int ch=sc.nextInt();
            if(ch==1){
                System.out.print("Question id: ");
                session.visitQuestion(sc.nextInt());
            }
            else if(ch==2){
                System.out.print("Question id: ");
                int q=sc.nextInt();
                System.out.print("Answer: ");
                session.answerQuestion(q,sc.next());
            }
            else if(ch==3){
                if(session.navigation.isEmpty()){
                    System.out.println("No previous question");
                }else{
                    System.out.println("Last visited: "+session.navigation.pop());
                }
            }
            else{
                int result=evaluate(session.answers);
                System.out.println("Final Score: "+result);
                break;
            }
        }
    }
}
