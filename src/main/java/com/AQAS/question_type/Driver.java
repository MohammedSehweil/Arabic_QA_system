package com.AQAS.question_type;


import com.AQAS.document_retrieval.HelpersD;
import opennlp.tools.util.StringList;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import weka.core.Instance;
import weka.core.tokenizers.NGramTokenizer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;


import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instances;

public class Driver {


    /**
     */
    public static void main(String[] args) throws Exception {
         Instances ngrammedVectores =  HelpersQT.initializeStringToWordVector();

    }
}