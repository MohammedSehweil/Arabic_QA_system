package com.AQAS.keyphrase_extraction;

import java.util.HashMap;

public class keyphraseExtraction {
    public static String[] keyphraseInput(int numOfKeys,String text,boolean arabic) {


//        HashMap<String, String[]> results = new HashMap<String, String>();

        KPMiner kpminer = new KPMiner(numOfKeys,text,arabic);

        String [] topNkeys = kpminer.getNkeyPhrases();
        return topNkeys;

    }
}
