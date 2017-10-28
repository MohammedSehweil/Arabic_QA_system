package com.AQAS.Document_ranking;

import com.AQAS.keyphrase_extraction.HelpersKE;
import com.AQAS.question_processessing.ConfigP;
import com.AQAS.question_processessing.QuestionPreprocessing;

import java.util.HashMap;

public class DocumentRanking {

    public static double getDocumentRank(String document, String query) {

        double rank = 0;

        String[] keyPhrases = HelpersKE.getKeyPhrases(query);

        HashMap<String, Double> keyPhrasesFrequencies = HelpersDR.getWordsFreqInDoc(keyPhrases, document);
        double cosineSimilarity = HelpersDR.cosineSimilarity(query, document);


        double keyPhrasesScore = 0;
        for (String keyPhrase : keyPhrases) {
            double keyPhraseScore=0;
            double keyPhraseFreq = keyPhrasesFrequencies.get(keyPhrase);
            int keyPhraseLength = HelpersDR.getSentenceWordsCount(keyPhrase);
            double properNameScore = getProperNameScore(keyPhrase);
            keyPhraseScore = keyPhraseFreq * Math.sqrt(keyPhraseLength) * properNameScore;
//            System.out.println(keyPhrase + " " + keyPhraseFreq + " " +  Math.sqrt(keyPhraseLength)  + " " +  properNameScore);
            keyPhrasesScore += keyPhraseScore;
        }
        if(keyPhrasesScore == 0){
            return  cosineSimilarity;
        }

        return keyPhrasesScore * cosineSimilarity;

    }

    //TODO: @Aseel, POS tagger thingy
    public static double getProperNameScore(String keyPrase){

        return 1;
    }


}
