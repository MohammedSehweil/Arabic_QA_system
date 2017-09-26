package com.AQAS.question_processessing;

import com.AQAS.question_processessing.utilities.AraNormalizer;
import com.AQAS.question_processessing.utilities.DiacriticsRemover;
import com.AQAS.question_processessing.utilities.PunctuationsRemover;

public class Driver {

    // execution starts here
    public static void main(String[] args) {
        // create the stemmer
        String query = "ذهبت الطالبة الصغيرة الى المدرسة, ودرست الدروس جميعها, وحين جاء وقت الاختبار, نجحت طالبتنا بامتياز! المدارس لها دور كبير في تعليم ابنائنا الأحباء.";
        AraNormalizer arn = new AraNormalizer();
        DiacriticsRemover dr = new DiacriticsRemover();
        PunctuationsRemover pr = new PunctuationsRemover();
        String normalizedText = arn.normalize(query);
        normalizedText = dr.removeDiacritics(normalizedText);
        normalizedText = pr.removePunctuations(normalizedText);

        System.out.println("Text: " + query);
        System.out.println("Normalized text: " + normalizedText);

        ArabicStemmer arabicStemmer = new ArabicStemmer(query);
        String normlized_Sttemed_Query = arabicStemmer.outputFilePanelStemButtonActionPerformed();
        System.out.println(normlized_Sttemed_Query);
    }
}
