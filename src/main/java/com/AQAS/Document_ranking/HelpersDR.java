package com.AQAS.Document_ranking;


import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HelpersDR {
    /**
     * @param words: Arrays of words to get their frequencies
     * @param document
     * @return <Word,Freq>
     */

public static HashMap<String,Integer> getWordsFreqInDoc(String[] words, String document){
    HashMap<String,Integer> wordFrequencies = new HashMap<String,Integer>();

    for (String word: words) {
        Pattern pattern = Pattern.compile(word);
        Matcher matcher = pattern.matcher(document);
        int count = 0;
        while (matcher.find())
            count++;
        wordFrequencies.put(word,count);
    }

    return wordFrequencies;
}

}
