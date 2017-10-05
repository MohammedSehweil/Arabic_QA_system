package com.AQAS.main;

import com.AQAS.Database.Document;
import com.AQAS.Database.Form;
import com.AQAS.document_retrieval.DocumentRetrieval;
import com.AQAS.document_retrieval.Website_Document;
import com.AQAS.question_processessing.QuestionPreprocessing;

import java.util.ArrayList;
import java.util.HashMap;

public class HelpersM {

    public static Form retrieveDocuments(int form_id) {
        Form form = new Form(form_id);
        form.getDocuments();
        return form;
    }


    public static Form retrieveDocuments(String query_string) {
        HashMap<String, String> out = QuestionPreprocessing.preProcessInput(ConfigM.query);

        Form form = new Form(query_string);
        ArrayList<Website_Document> website_documents = DocumentRetrieval.getLinksOfAllWebsitesByQuery(form.text, ConfigM.searchNumOfPages);

        //printing the links
        if (ConfigM.VERBOS) {
            System.out.println("All Links:");
        }

        for (Website_Document website_document : website_documents) {
            for (String url : website_document.DocumentLinks) {
                if (ConfigM.VERBOS) {
                    System.out.println(url);
                }
                String text = DocumentRetrieval.retrieveDocumentText(url , website_document.websiteContentSelector);
                form.documents.add(new Document(url, text));
            }
//            System.out.println("----------------------");
        }
        return form;
    }


}
