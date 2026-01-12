import java.util.*;
class ExamTimeExpiredException extends Exception {
    public ExamTimeExpiredException(String msg) {
        super(msg);
    }
}


interface EvaluationStrategy {
    int evaluate(List<String> answers, List<Question> questions);
}


class ObjectiveEvaluation implements EvaluationStrategy {
    public int evaluate(List<String> answers, List<Question> questions) {
        int score = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).equalsIgnoreCase(questions.get(i).correctAnswer))
                score += 1;
        }
        return score;
    }
}

class DescriptiveEvaluation implements EvaluationStrategy {
    public int evaluate(List<String> answers, List<Question> questions) {
        return answers.size() * 2; // manual/assumed marks
    }
}

class Question {
    String questionText;
    String correctAnswer;

    Question(String q, String a) {
        questionText = q;
        correctAnswer = a;
    }
}


class Exam {
    String examName;
    List<Question> questions = new ArrayList<>();
    EvaluationStrategy strategy;

    Exam(String name, EvaluationStrategy strategy) {
        this.examName = name;
        this.strategy = strategy;
    }

    void addQuestion(Question q) {
        questions.add(q);
    }
}

// ================= Student =================
class StudentS {
    int studentId;
    String name;
    List<String> answers = new ArrayList<>();

    StudentS(int id, String name) {
        this.studentId = id;
        this.name = name;
    }

    void submitAnswers(List<String> ans, boolean timeExpired)
            throws ExamTimeExpiredException {
        if (timeExpired)
            throw new ExamTimeExpiredException("Exam time expired!");
        answers = ans;
    }
}

// ================= Main Driver =================
public class OnlineExamSystem {
    public static void main(String[] args) {

        Exam exam = new Exam("Java Test", new ObjectiveEvaluation());
        exam.addQuestion(new Question("What is JVM?", "virtual machine"));
        exam.addQuestion(new Question("What is OOP?", "object oriented"));

        StudentS s1 = new StudentS(1, "Amit");

        try {
            s1.submitAnswers(
                    Arrays.asList("virtual machine", "object oriented"), false);
            int result = exam.strategy.evaluate(s1.answers, exam.questions);
            System.out.println("Result: " + result);
        } catch (ExamTimeExpiredException e) {
            System.out.println(e.getMessage());
        }
    }
}
