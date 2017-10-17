package com.AQAS.question_type;

import weka.core.Instances;

import java.util.ArrayList;

public class HelpersQT {

//TODO: make it return list of questions with their type
    public static void getQuestionTypeUsingSVM(ArrayList<String> testingQuestions){
        Instances ngrammedVectors = null;
        try {
            ngrammedVectors = FeatureVector.applyFilterOnData(testingQuestions);
            MachineLearning.buildClassifier(ngrammedVectors);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
