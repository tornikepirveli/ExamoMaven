package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class Examo implements ExamoInterface {

    private ArrayList<FullQuesion> exam;
    int num;

    @Override
    public void initQuiz(ArrayList<FullQuesion> exam, int num) {
        this.exam = exam;
        this.num = num;
    }
    Examo(ArrayList<FullQuesion> exam, int num){
        initQuiz(exam,num);
    }

    Examo(ArrayList<FullQuesion> exam){
        initQuiz(exam,exam.size());
    }
}
