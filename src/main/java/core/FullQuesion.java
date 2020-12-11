package core;

public class FullQuesion {

    private Question question;
    private Answer[] Answers;
    private Answer correctAnswer;

    FullQuesion(Question question, Answer[] Answers, Answer correctAnswer){
        this.question = question;
        this.Answers = Answers;
        this.correctAnswer = correctAnswer;
    }

    FullQuesion(Question question, Answer[] Answers){
        this.question = question;
        this.Answers = Answers;
        this.correctAnswer = null;
    }
}
