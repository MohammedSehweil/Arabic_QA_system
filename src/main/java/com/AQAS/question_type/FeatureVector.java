package com.AQAS.question_type;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVLoader;
import weka.core.converters.CSVSaver;
import weka.core.tokenizers.NGramTokenizer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class FeatureVector {

    public static int orginalTrainingSize ;
    //example
    // FileName =".\\src\\main\\java\\com\\AQAS\\question_type\\t.arff";
    public static Instances getTrainingData(String fileName, int fileType) throws IOException {

        Instances data = null;
        if (fileType == ConfigQT.CSV_FILE) {

            //TODO data is converted to feature vectors(fix this)
            CSVLoader loader = new CSVLoader();
            loader.setFile(new File(fileName));
            data = loader.getDataSet();
        } else {
            ArffLoader loader = new ArffLoader();
            loader.setFile(new File(fileName));
            data = loader.getDataSet();
        }
        data.setClassIndex(data.numAttributes() - 1);
        System.out.println(data);
        return data;
    }


    //get data manually
    public static Instances getTrainingData() {

        //reference https://codereview.stackexchange.com/questions/160027/convert-java-data-to-weka-friendly-format-without-using-arff
        ArrayList<Attribute> atts;
        ArrayList<String> attVals;
        Instances data;
        double[] vals;

        // 1. set up attributes
        atts = new ArrayList<Attribute>();
        // - string
        atts.add(new Attribute("question", (ArrayList<String>) null));
        // - nominal
        attVals = new ArrayList<String>();
        attVals.addAll(Arrays.asList(ConfigQT.QT_texts));
        atts.add(new Attribute("QuestionType", attVals));


        // 2. create Instances object
        data = new Instances("MyRelation", atts, 0);
        // 3. fill with data
        ArrayList<arffEntry> inputData = getDataManually();
        for (arffEntry a : inputData) {
            vals = new double[data.numAttributes()];
            vals[0] = data.attribute(0).addStringValue(a.text);
            vals[1] = a.questionTypeIndex;
            data.add(new DenseInstance(1.0, vals));
        }
        data.setClassIndex(data.numAttributes() - 1);//set QuestionType as the class index
        // 4. output data
        System.out.println(data);

        return data;

    }

    private static ArrayList<arffEntry> getDataManually() {

        ArrayList<arffEntry> ret = new ArrayList<arffEntry>();

        //TODO: this is dummy data, we have to add it from training data
        ret.add(new arffEntry("my name is maher", ConfigQT.QT_NUMERIC));
        ret.add(new arffEntry("my name is ziad", ConfigQT.QT_LIST));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));

        return ret;
    }

    private static StringToWordVector _initializeStringToWordVector(){
        StringToWordVector stringToWordVector = new StringToWordVector();
        stringToWordVector.setIDFTransform(true);
        stringToWordVector.setTFTransform(true);

        NGramTokenizer nGramTokenizer = new NGramTokenizer();
        nGramTokenizer.setNGramMinSize(ConfigQT.MIN_NGRAM);
        nGramTokenizer.setNGramMaxSize(ConfigQT.MAX_NGRAM);
        nGramTokenizer.setDelimiters(" \n" + " \t.,;:'\"()?!");
        stringToWordVector.setTokenizer(nGramTokenizer);


        stringToWordVector.setAttributeIndices("question");
        stringToWordVector.setAttributeIndices("TypeClass");
        stringToWordVector.setAttributeIndices("first-last");

        return stringToWordVector;

    }


    public static Instances applyFilterOnData(  ArrayList<String> testingQuestions) throws Exception {

        StringToWordVector stringToWordVector = _initializeStringToWordVector();
        Instances data = null;
        int fileType = ConfigQT.FILE_TYPE;
        //getting data
        if (fileType == ConfigQT.MANUALLY_DATA) {
            data = FeatureVector.getTrainingData();
        } else {
            data = FeatureVector.getTrainingData(ConfigQT.TRAINING_INPUT_FILE, fileType);
        }

        orginalTrainingSize = data.size();
        //adding testing questions
        for (String testingQuestion:testingQuestions) {
            double[] vals;
            vals = new double[data.numAttributes()];
            vals[0] = data.attribute(0).addStringValue(testingQuestion);
            DenseInstance d = new DenseInstance(1.0, vals);
            d.setMissing(1);
            data.add(d);
        }
        System.out.println("___**************_");
        System.out.println(data);


        stringToWordVector.setInputFormat(data);

        System.out.println("**********************************");
        Instances filteredData = Filter.useFilter(data, stringToWordVector);
        filteredData.setClassIndex(0);// set the questionType as the class index for machine learning
        System.out.println(filteredData);

        saveDatatoCsvFile(filteredData, ConfigQT.FILTERED_DATA_FILE);
        return filteredData;
    }

    public static void saveDatatoCsvFile(Instances data, String fileName) throws IOException {
        if (fileName == null)
            fileName = "output.csv";
        CSVSaver saver = new CSVSaver();
        saver.setInstances(data);
        saver.setFile(new File(fileName));
        saver.writeBatch();
    }
}

class arffEntry {
    String text;
    int questionTypeIndex;

    public arffEntry(String text, int questionType) {
        this.text = text;
        this.questionTypeIndex = questionType;
    }
}
