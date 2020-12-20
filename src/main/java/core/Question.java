package core;

public class Question implements ClassType {
    private String body;

    public Question(String body){
        this.body = body;
    }

    @Override
    public String getBody() {
        return body;
    }

    @Override
    public String getType() {
        return Question.class.getTypeName();
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
