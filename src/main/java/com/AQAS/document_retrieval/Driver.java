package com.AQAS.document_retrieval;


import java.io.IOException;
import java.util.ArrayList;
import static com.AQAS.document_retrieval.HelpersD.closeWebDriver;
import static com.AQAS.document_retrieval.HelpersD.openWebDriver;

public class Driver {

    public static void main(String[] args) throws IOException {


        openWebDriver();

        String query = "ما هي أعراض مرض السكري؟";
        //Specify the number of search pages result to be used.
        int searchNumOfPages = 2;
        ArrayList<Website_Document> website_documents = DocumentRetrieval.getLinksOfAllWebsitesByQuery(query, searchNumOfPages);
        //printing the links
        if (ConfigD.VERBOS) {
            System.out.println("All Links:");
            for (Website_Document website_document : website_documents) {
                for (String url : website_document.DocumentLinks) {
                    System.out.println(url);
                }
            }
        }

        closeWebDriver();

    }
}
