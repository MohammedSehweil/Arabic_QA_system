package com.AQAS.question_type;

public final class ConfigQT {


    public static final int QT_NUMERIC = 0;
    public static final int QT_LIST = 1;
    public static final int QT_PARAGRAPH = 2;

//IF YOU WANNA ADD NEW QUESTION TYPE,PLEASE ADD ITS INDEX AS CONSTANT ABOVE :)
    public static final String[] QT_texts={"Numeric","List","Paragraph"};

    public static final int CSV_FILE = 0;
    public static final int ARFF_FILE = 1;
    public static final int MANUALLY_DATA = 2;

//Classifier model parameters
    public static final boolean BUILD_MODEL = true;
    public static final String MODEL_FILE_NAME = "smo.model";


//FeatureVector filter parameters
    public static final int MIN_NGRAM=1;
    public static final int MAX_NGRAM=1;
    public static final String TRAINING_INPUT_FILE = "test_files\\training.arff";
    public static final String FILTERED_DATA_FILE = "filtered_data.csv";

    public static final int FILE_TYPE = ConfigQT.ARFF_FILE;

    public final class Keys {
    }


}
