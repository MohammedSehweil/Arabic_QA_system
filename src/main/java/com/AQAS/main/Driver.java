package com.AQAS.main;


import com.AQAS.Database.Form;
import com.AQAS.document_retrieval.DocumentRetrieval;
import com.AQAS.document_retrieval.HelpersD;
import com.AQAS.question_processessing.ConfigP;
import com.AQAS.question_processessing.HelpersP;
import com.AQAS.question_processessing.QuestionPreprocessing;

import java.util.ArrayList;
import java.util.HashMap;

import static com.AQAS.Database.HelpersDB.intializeProb;
import static com.AQAS.Database.HelpersDB.storeTestingData;
import static com.AQAS.main.HelpersM.retrieveDocuments;

public class Driver {

    public static void main(String[] args) {

        intializeProb();
        if(ConfigM.BUILDDB){
            storeTestingData();
        }

        Form form = retrieveDocuments(1);

        System.out.println(form);
    }
}
