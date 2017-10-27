package com.AQAS.keyphrase_extraction;

import KPminer.Extractor;

public class HelpersKE {

    public static String[] getKeyPhrases(String Query){

        Extractor extractor = new Extractor();
        extractor.init();
        String [] topKeys = extractor.getTopN(ConfigKE.KP_NUMBER,Query,true);

        return topKeys;
    }


}
