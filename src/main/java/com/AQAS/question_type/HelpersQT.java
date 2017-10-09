package com.AQAS.question_type;


import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HelpersQT {




    public static Instances createAarfJava(String FileName) throws IOException {
//        FileName =".\\src\\main\\java\\com\\AQAS\\question_type\\t.arff"; //example
        ArffLoader loader = new ArffLoader();
        loader.setFile(new File(FileName));
        Instances data = loader.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        return data;
    }

    public static Instances createAarfJava(){

        //reference https://codereview.stackexchange.com/questions/160027/convert-java-data-to-weka-friendly-format-without-using-arff
        ArrayList<Attribute> atts;
        ArrayList<Attribute> attsRel;
        ArrayList<String> attVals;
        ArrayList<String> attValsRel;
        Instances data;
        Instances dataRel;
        double[] vals;
        double[] valsRel;
        int i;

        // 1. set up attributes
        atts = new ArrayList<Attribute>();
        // - string
        atts.add(new Attribute("question", (ArrayList<String>) null));
        // - nominal
        attVals = new ArrayList<String>();
        attVals.add("numaric");
        attVals.add("list");
        attVals.add("paragraph");
        atts.add(new Attribute("QuestionType", attVals));


        // 2. create Instances object
        data = new Instances("MyRelation", atts, 0);

        // 3. fill with data
        // first instance
        vals = new double[data.numAttributes()];
        vals[0] = data.attribute(0).addStringValue("This is a string1!");
        vals[1] = 0;
        data.add(new DenseInstance(1.0, vals));

        vals = new double[data.numAttributes()];
        vals[0] = data.attribute(0).addStringValue("This is a string2!");
        vals[1] = 1;
        data.add(new DenseInstance(1.0, vals));

        vals = new double[data.numAttributes()];
        vals[0] = data.attribute(0).addStringValue("This is a strin3!");
        vals[1] = 2;
        data.add(new DenseInstance(1.0, vals));


        // 4. output data
        System.out.println(data);

        return data;

    }


}
