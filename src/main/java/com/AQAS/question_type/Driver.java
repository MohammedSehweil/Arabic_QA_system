package com.AQAS.question_type;


import opennlp.tools.util.StringList;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Driver {

    public static void main(String[] args) {

        int n = 2; //n-gram
        String[] s = "I saw the fox saw the fox".split(" ");
        Collection<StringList> nGrams = NGramUtils.getNGrams(new StringList(s), n);
        Collection<StringList> nGrams_cloned = NGramUtils.getNGrams(new StringList(s), n);


        Set<StringList> hs = new HashSet<>();
        hs.addAll(nGrams_cloned);
        nGrams_cloned.clear();
        nGrams_cloned.addAll(hs);

//        System.out.println(nGrams);
        System.out.println(nGrams_cloned);
        for (StringList stringList : nGrams_cloned) {
            if (n == 1) {
                System.out.println(stringList.toString() + ": " + NGramUtils.calculateUnigramMLProbability(stringList.getToken(0), nGrams));
            } else if (n == 2) {
                System.out.println(stringList.toString() + ": " + NGramUtils.calculateNgramMLProbability(stringList, nGrams));
            }
        }
    }
}
