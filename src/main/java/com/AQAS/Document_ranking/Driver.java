package com.AQAS.Document_ranking;


import com.AQAS.Document_ranking.stringsimilarity.Cosine;

import java.util.Map;

public class Driver {

    public static void main(String[] args) {
        cosineSimilarity();

    }

    public static void cosineSimilarity(){
        //https://github.com/tdebatty/java-string-similarity
        String s1 = "My first string";
        String s2 = "My other string";

        Cosine cosine = new Cosine(100);//100 or any number

        System.out.println(cosine.getProfileByWordSplitting(s1));
        System.out.println(cosine.getProfileByWordSplitting(s2));
        // Pre-compute the profile of strings
        Map<String, Integer> profile1 = cosine.getProfileByWordSplitting(s1);
        Map<String, Integer> profile2 = cosine.getProfileByWordSplitting(s2);

        // Prints 0.516185
        System.out.println(cosine.similarity(profile1, profile2));

    }
}
