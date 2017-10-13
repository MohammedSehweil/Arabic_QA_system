package com.AQAS.question_type;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.SMO;
import weka.core.Instances;

import java.util.Random;


/**
 * https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
 */
public class MachineLearning {



    public static void buildClassifier(Instances data) {

        try {
            SMO classifier = new SMO();
            data.setClassIndex(0);// set the questionType as the class index for machine learning

            if (ConfigQT.BUILD_MODEL) {
                classifier.buildClassifier(data);
                weka.core.SerializationHelper.write(ConfigQT.MODEL_FILE_NAME, classifier);
            } else {
                classifier = (SMO) weka.core.SerializationHelper.read(ConfigQT.MODEL_FILE_NAME);
            }

            for (int i = FeatureVector.originalTrainingSize; i < data.size(); i++) {
                System.out.println("Classification Class is:" + ConfigQT.QT_texts[(int)classifier.classifyInstance(data.get(i))]);
            }

            Evaluation eval = new Evaluation(data);
            eval.crossValidateModel(classifier, data, 10, new Random(System.currentTimeMillis()));

            System.out.println("\n(k-folds results):" + eval.toSummaryString());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
