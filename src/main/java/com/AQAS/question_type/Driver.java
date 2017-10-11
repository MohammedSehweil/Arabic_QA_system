package com.AQAS.question_type;


import weka.core.Instances;

public class Driver {


    public static void main(String[] args) throws Exception {
        Instances ngrammedVectores = FeatureVector.initializeStringToWordVector(1, 1, ConfigQT.MANUALLY_DATA,  null, "output.csv");

        MachineLearning.initializeClassifier(ngrammedVectores);
    }
}