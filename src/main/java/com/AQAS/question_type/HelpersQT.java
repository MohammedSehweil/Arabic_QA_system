package com.AQAS.question_type;


import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.tokenizers.NGramTokenizer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HelpersQT {


    public static Instances getAarfData(String FileName) throws IOException {
//        FileName =".\\src\\main\\java\\com\\AQAS\\question_type\\t.arff"; //example
        ArffLoader loader = new ArffLoader();
        loader.setFile(new File(FileName));
        Instances data = loader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);
        System.out.println(data);
        return data;
    }

    public static Instances getAarfData() {

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
        attVals.add(ConfigQT.QT_NUMERIC_TEXT);
        attVals.add(ConfigQT.QT_LIST_TEXT);
        attVals.add(ConfigQT.QT_PARAGRAPH_TEXT);
        atts.add(new Attribute("QuestionType", attVals));


        // 2. create Instances object
        data = new Instances("MyRelation", atts, 0);
        // 3. fill with data
        ArrayList<arffEntry> inputData = getData();
        for (arffEntry a : inputData) {
            vals = new double[data.numAttributes()];
            vals[0] = data.attribute(0).addStringValue(a.text);
            vals[1] = a.questionTypeIndex;
            data.add(new DenseInstance(1.0, vals));
        }
        data.setClassIndex(data.numAttributes() - 1);
        // 4. output data
        System.out.println(data);

        return data;

    }

    private static ArrayList<arffEntry> getData() {

        ArrayList<arffEntry> ret = new ArrayList<arffEntry>();

        //TODO: this is dummy data, we have to add it from training data
        ret.add(new arffEntry("my name is maher", ConfigQT.QT_NUMERIC));
        ret.add(new arffEntry("my name is ziad", ConfigQT.QT_LIST));
        ret.add(new arffEntry("my name is aseel", ConfigQT.QT_PARAGRAPH));

        return ret;
    }


    public static Instances initializeStringToWordVector(int minNgram, int maxNgram) throws Exception {
        StringToWordVector stringToWordVector = new StringToWordVector();
        stringToWordVector.setIDFTransform(true);
        stringToWordVector.setTFTransform(true);

        NGramTokenizer nGramTokenizer = new NGramTokenizer();
        nGramTokenizer.setNGramMaxSize(minNgram);
        nGramTokenizer.setNGramMinSize(maxNgram);
        nGramTokenizer.setDelimiters(" \n" + " \t.,;:'\"()?!");
        stringToWordVector.setTokenizer(nGramTokenizer);


        stringToWordVector.setAttributeIndices("review");
        stringToWordVector.setAttributeIndices("TypeClass");
        stringToWordVector.setAttributeIndices("first-last");

        //getting data
        Instances data = HelpersQT.getAarfData();
        stringToWordVector.setInputFormat(data);
        for (int i = 0; i < data.size(); i++) {
            stringToWordVector.input(data.get(i));
        }
        System.out.println("**********************************");
        Instances newData = Filter.useFilter(data, stringToWordVector);
        System.out.println(newData);
        return newData;
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
