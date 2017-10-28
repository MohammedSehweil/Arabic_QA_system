package com.AQAS.Document_ranking;


import com.AQAS.Document_ranking.stringsimilarity.Cosine;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HelpersDR {
    /**
     * @param words:   Arrays of words to get their frequencies
     * @param document
     * @return <Word,Freq>
     */

    public static HashMap<String, Double> getWordsFreqInDoc(String[] words, String document) {
        HashMap<String, Double> wordFrequencies = new HashMap<String, Double>();

        for (String word : words) {
            Pattern pattern = Pattern.compile(word);
            Matcher matcher = pattern.matcher(document);
            double count = 0;
            while (matcher.find())
                count++;

            int documentWordsCount = getSentenceWordsCount(document);
//            wordFrequencies.put(word, count/documentWordsCount); //Normalized freq
            wordFrequencies.put(word, count);

        }

        return wordFrequencies;
    }

    public static double cosineSimilarity(String s1, String s2){
        //https://github.com/tdebatty/java-string-similarity

        Cosine cosine = new Cosine(100);//100 or any number


        // Pre-compute the profile of strings
        Map<String, Integer> profile1 = cosine.getProfileByWordSplitting(s1);
        Map<String, Integer> profile2 = cosine.getProfileByWordSplitting(s2);
        System.out.println(profile1);
        System.out.println(profile2);


        double result = cosine.similarity(profile1, profile2);
        System.out.println(result);
        return result;
    }

    public static int getSentenceWordsCount(String sentence){
        String trim = sentence.trim();
        if (trim.isEmpty())
            return 0;
        return trim.split("\\s+").length; // separate string around spaces
    }

}
