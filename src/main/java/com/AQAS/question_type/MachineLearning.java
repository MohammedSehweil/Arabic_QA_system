package com.AQAS.question_type;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instances;

import java.util.Random;


/**
 * https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
 */
public class MachineLearning {

    public static void initializeClassifier(Instances data) {


        try {
            SMO classifier = new SMO();
            data.setClassIndex(0);// set the questionType as the class index for machine learning
            classifier.buildClassifier(data);
            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(classifier, data, 10, new Random(1));

            System.out.println("\nSummary:" + eval.toSummaryString());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
