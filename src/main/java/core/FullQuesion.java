package core;

import java.util.List;

public class FullQuesion {

    public Question question;
    public List<Answer> Answers;
    public Answer correctAnswer;

    public FullQuesion(Question question, List<Answer> Answers, Answer correctAnswer){
        this.question = question;
        this.Answers = Answers;
        this.correctAnswer = correctAnswer;
    }

    public FullQuesion(Question question, List<Answer> Answers){
        this.question = question;
        this.Answers = Answers;
        this.correctAnswer = null;
    }
}
