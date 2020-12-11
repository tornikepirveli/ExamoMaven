package core;

public class Answer implements ClassType {
    private int score;
    private boolean scoreIsValid;
    private String body;

    Answer(int score, String body){
        this.body = body;
        this.score = score;
        scoreIsValid = true;
    }

    Answer(String body){
        this.body = body;
        scoreIsValid = false;
        score = 0;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public String getType() {
        return Answer.class.getTypeName();
    }

    @Override
    public String toText() {
        return null;
    }

    @Override
    public String toPdf() {
        return null;
    }
}
