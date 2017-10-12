package com.AQAS.question_type;


import weka.core.Instances;

import java.util.ArrayList;
import java.util.Arrays;

import static com.AQAS.question_type.HelpersQT.getQuestionTypeUsingSVM;

public class Driver {


    public static void main(String[] args) throws Exception {
        ArrayList<String> testingQuestions = new ArrayList<String>(Arrays.asList(
                "how are",
                "my maher"
        ));

        getQuestionTypeUsingSVM(testingQuestions);
    }
}