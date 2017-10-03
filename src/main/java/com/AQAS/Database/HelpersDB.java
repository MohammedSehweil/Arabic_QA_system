package com.AQAS.Database;

import com.AQAS.document_retrieval.HelpersD;
import com.AQAS.main.ConfigM;
import com.AQAS.question_processessing.ConfigP;
import com.AQAS.question_processessing.QuestionPreprocessing;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;

import static com.AQAS.document_retrieval.DocumentRetrieval.retrieveDocumentText;


public class HelpersDB {

    public static Properties props = null;

    public static void storeTestingData() {
        intializeProb();
        for (Question question : ConfigDB.testingQuestions) {
            int question_id = question.store();
//            System.out.println(question_id);
            for (Form form : question.forms) {
                form.text = QuestionPreprocessing.preProcessInput(form.text).get(ConfigP.Keys.NormalizedText);

                form.question_id = question_id;
                int form_id = form.store();
                ArrayList<String> searchResultURLs = HelpersD.getLinks(form.text, ConfigM.searchNumOfPages);
                for (String url : searchResultURLs) {
                    String documentText = retrieveDocumentText(url);
                    Document newDoc = new Document(url, documentText);
                    newDoc.form_id = form_id;

                    newDoc.store();
                }


            }


        }

    }

    public static void intializeProb() {
        props = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/AQAS/Database/" + "/db.properties");
            props.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
