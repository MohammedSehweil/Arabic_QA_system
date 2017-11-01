package com.AQAS.synonyms;


import com.AQAS.keyphrase_extraction.keyphraseExtraction;

import java.util.ArrayList;

public class Driver {

    // execution starts here
    public static void main(String[] args) {
        FindSynonyms fs = new FindSynonyms("وقاية");
        ArrayList<String> wordSynset= fs.wordSynset();
        for(int i = 0; i<wordSynset.size();i++){
            System.out.println(wordSynset.get(i));
        }
    }
}