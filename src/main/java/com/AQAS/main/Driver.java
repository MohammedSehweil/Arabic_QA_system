package com.AQAS.main;


import com.AQAS.document_retrieval.Config;
import com.AQAS.document_retrieval.DocumentRetrieval;
import com.AQAS.document_retrieval.Website;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Driver {

    public static void main(String[] args) throws IOException {

        String searchQuery = "السكري";
        //Specify the number of search pages result to be used.
        int searchNumOfPages = 2;
        ArrayList<String> searchResultURLs = new ArrayList<String>();

        HashMap<String,Object> searchAttr = new HashMap<String, Object>();
        searchAttr.put("searchQuery","السكري");
        searchAttr.put("searchNumOfPages",2);


        for (Website website:Config.webSites) {

            searchResultURLs.addAll(new DocumentRetrieval().getLinks(website,searchAttr));
        }
    }
}
