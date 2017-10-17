package com.AQAS.main;


import com.AQAS.Database.Form;
import com.AQAS.document_retrieval.DocumentRetrieval;
import com.AQAS.document_retrieval.HelpersD;
import com.AQAS.question_processessing.ConfigP;
import com.AQAS.question_processessing.HelpersP;
import com.AQAS.question_processessing.QuestionPreprocessing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.AQAS.Database.HelpersDB.intializeProb;
import static com.AQAS.Database.HelpersDB.storeTestingData;
import static com.AQAS.document_retrieval.HelpersD.closeWebDriver;
import static com.AQAS.document_retrieval.HelpersD.openWebDriver;
import static com.AQAS.main.HelpersM.retrieveDocuments;
import static com.AQAS.question_type.HelpersQT.getQuestionTypeUsingSVM;

public class Driver {

    public static void main(String[] args) throws IOException {

        intializeProb();
        openWebDriver();
        if (ConfigM.BUILD_DB) {
            storeTestingData();
        }

        getQuestionTypeUsingSVM(new ArrayList<>(Arrays.asList(ConfigM.query)));


//        Form form = retrieveDocuments(ConfigM.query);

//        System.out.println(form);

        closeWebDriver();
    }
}
