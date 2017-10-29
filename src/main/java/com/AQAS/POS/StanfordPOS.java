package com.AQAS.POS;
import edu.stanford.nlp.io.IOUtils;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.util.*;
//import edu.stanford.nlp.simple.*;
import edu.stanford.nlp.util.CoreMap;
import javafx.util.Pair;

public class StanfordPOS {
    private String text;

    public StanfordPOS(String text) {
        this.text = text;
    }

    public  ArrayList<Pair<String,String>> tokenPOS(){
        Annotation document = new Annotation(text);
        // Setup Chinese Properties by loading them from classpath resources
        Properties props = new Properties();
        try{
            props.load(IOUtils.readerFromString("StanfordCoreNLP-arabic.properties"));
        } catch(java.io.IOException e){
            System.out.println("createDirectory failed:" + e);
        }
        StanfordCoreNLP corenlp = new StanfordCoreNLP(props);
        corenlp.annotate(document);

        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        ArrayList<Pair<String,String>> myArrayList = new ArrayList<>();
        for(CoreMap sentence: sentences) {
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
//                // this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
//                // this is the POS tag of the token
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                Pair<String, String> myPair = new Pair<>(word, pos);
                myArrayList.add(myPair);
            }
        }
        return myArrayList;
    }
}
