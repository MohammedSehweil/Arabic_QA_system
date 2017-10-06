package com.AQAS.document_retrieval;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Website_Document {

    public String websiteContentSelector;
    public ArrayList<String> DocumentLinks;
    public String sourceWebsite;

    public void removeDuplicatedDocumentLinks(ArrayList<String> a){
//        ArrayList<String> al = a;
//        // add elements to al, including duplicates
//        Set<String> hs = new HashSet<String>();
//        hs.addAll(al);
//        al.clear();
//        al.addAll(hs);
        this.DocumentLinks.removeAll(a);
    }
}
