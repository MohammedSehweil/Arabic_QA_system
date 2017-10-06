package com.AQAS.Database;

import static com.AQAS.Database.HelpersDB.storeTestingData;
import static com.AQAS.Database.HelpersDB.intializeProb;
import static com.AQAS.document_retrieval.HelpersD.closeWebDriver;
import static com.AQAS.document_retrieval.HelpersD.openWebDriver;

public class Driver {

    public static void main(String[] args) {

        openWebDriver();
        intializeProb();
        storeTestingData();
//        Form f = new Form(31);
//        f.getDocuments();
//        System.out.println(f);

        closeWebDriver();


    }


}