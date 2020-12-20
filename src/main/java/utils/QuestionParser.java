package utils;

import core.Answer;
import core.FullQuesion;
import core.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class QuestionParser {

    private static final String[] QUESTION_BODY_END = {"asd","asda"};
    private List<FullQuesion> fullQuesions;
    private List<Answer> tempQuesion;
    private FullQuesion temp;
    private String file;
    private String tempQuestion;

    public QuestionParser(String file) {
        this.file = file;
        ParseFunction();
        temp = new FullQuesion(new Question(tempQuestion), new LinkedList<>());
    }

    private boolean ParseFunction () {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
//            while (true) {
//                String reading = reader.readLine();
//                body.append(reading).append(" ");
//                if (reading.endsWith(QUESTION_BODY_END[0]) || reading.endsWith(QUESTION_BODY_END[1])) break;
//            }
//            Map<String, Double> answers = new HashMap<>();
//            while (true) {
//                String[] probAnswer = reader.readLine().split(PROB_ANSWERS_REGEX);
//                if (probAnswer.length == 1) break;
//                String answerBody = probAnswer[0];
//                Double answerPoint = Double.parseDouble(probAnswer[1]);
//                answers.put(answerBody, answerPoint);
//            }
//            return new TestQuestion(body.toString(), answers);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Question getQuestion(String type, BufferedReader reader) throws IOException {
//        try {
//            return functionMap.get(type).apply(reader);
//        } catch (NullPointerException e){
//            System.out.println("Such type of question doesn't exist");
//            while(!reader.readLine().equals(QUESTION_SPLITTER)){}
//            return null;
//        }
        return null;
    }
}
