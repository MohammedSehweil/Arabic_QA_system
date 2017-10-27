package com.AQAS.Document_ranking;


import com.AQAS.keyphrase_extraction.HelpersKE;

import java.util.HashMap;

public class Driver {

    public static void main(String[] args) {

        String [] keyPhrases = HelpersKE.getKeyPhrases("أعراض مرض السكري و أسبابه و سبل الوقاية منه");
        HashMap<String,Integer> keyPhrasesFrequencies = HelpersDR.getWordsFreqInDoc(keyPhrases,ConfigDR.testingDoc);

        System.out.println(keyPhrasesFrequencies);
    }
}
