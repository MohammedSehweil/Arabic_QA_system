package com.AQAS.document_retrieval;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Driver {

    public static void main(String[] args) throws IOException {

        String searchQuery = "السكري";
        //Specify the number of search pages result to be used.
        int searchNumOfPages = 2;
        ArrayList<String> searchResultURLs = new ArrayList<String>();
        DocumentRetrieval DR = new DocumentRetrieval();

        HashMap<String,Object> searchAttr = new HashMap<String, Object>();
        searchAttr.put("searchQuery","السكري");
        searchAttr.put("searchNumOfPages",2);

        searchResultURLs = DR.getLinksFromAllWebsites(searchAttr);
        if (Config.VERBOS) {
            System.out.println("All Links:");
            for (String s : searchResultURLs) {
                System.out.println(s);
            }
        }

//        for (String url:searchResultURLs) {
//            DR.getDocument(url);
//            System.out.println("==========================");
//
//        }

    }
}
