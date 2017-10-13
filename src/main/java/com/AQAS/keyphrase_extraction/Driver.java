package com.AQAS.keyphrase_extraction;


import java.util.HashMap;

import KPminer.*;

public class Driver {

    // execution starts here
    public static void main(String[] args) {
        keyphraseExtraction kp = new keyphraseExtraction();
        Extractor extractor = new Extractor();
        extractor.init();
        String [] topKeys = extractor.getTopN(3,"أعراض مرض السكري و أسبابه و سبل الوقاية منه",true);
//        String[] topNkeys = kp.keyphraseInput(1,"What is the reason that cause cancer",false);

        for(int i = 0; i<topKeys.length; i++){
            System.out.println(topKeys[i]);
        }



    }
}
