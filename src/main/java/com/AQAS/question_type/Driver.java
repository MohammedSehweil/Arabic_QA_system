package com.AQAS.question_type;


import weka.core.Instances;

public class Driver {


    public static void main(String[] args) throws Exception {
        Instances ngrammedVectores = FeatureVector.initializeStringToWordVector(1, 1, ConfigQT.ARFF_FILE,  "C:\\Users\\the-m\\Desktop\\training.arff", "output.csv");

        MachineLearning.initializeClassifier(ngrammedVectores);
    }
}