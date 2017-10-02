package com.AQAS.main;

import com.AQAS.Database.Document;
import com.AQAS.Database.Form;
import com.AQAS.document_retrieval.DocumentRetrieval;
import com.AQAS.document_retrieval.HelpersD;
import com.AQAS.question_processessing.ConfigP;
import com.AQAS.question_processessing.QuestionPreprocessing;

import java.util.ArrayList;
import java.util.HashMap;

public class HelpersM {

    public static Form retrieveDocuments(int form_id){
        Form form = new Form(form_id);
        form.getDocuments();
        return form;
    }


    public static Form retrieveDocuments(String query_string){
        HashMap<String, String> out = QuestionPreprocessing.preProcessInput(ConfigM.query);

        Form form = new Form(query_string);
        ArrayList<String> searchResultURLs = HelpersD.getLinks(out.get(ConfigP.Keys.NormalizedText), ConfigM.searchNumOfPages);

        //printing the links
        if (ConfigM.VERBOS) {
            System.out.println("All Links:");
        }
        for (String url : searchResultURLs) {
            if(ConfigM.VERBOS){
                System.out.println(url);
            }
            String text = DocumentRetrieval.retrieveDocumentText(url);
            form.documents.add(new Document(url,text));

        }
        return form;
    }


}
