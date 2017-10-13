package com.AQAS.keyphrase_extraction;

import KPminer.*;

import java.util.concurrent.Executor;

public class KPMiner {
    private int n;
    private String text;
    private boolean ArLanguage;
    private boolean useCuttOff;
    private int cuttOff;
    private boolean applyPosRuel;
    private Extractor extractor;


    public KPMiner(int n, String text, boolean arLanguage) {
        this.n = n;
        this.text = text;
        ArLanguage = arLanguage;
        this.cuttOff = cuttOff;
        init(this.extractor);
    }

    public KPMiner(int n, String text, boolean arLanguage, boolean useCuttOff ,int cuttOff, boolean applyPosRuel) {
        this.n = n;
        this.text = text;
        ArLanguage = arLanguage;
        this.useCuttOff = useCuttOff;
        this.cuttOff = cuttOff;
        this.applyPosRuel = applyPosRuel;
        init2(this.extractor);

    }
    public void init(Extractor ex ){
        ex = new Extractor();
    }
    public void init2(Extractor ex ){
        ex = new Extractor();
        ex.setCutOff(this.cuttOff);
        ex.useCutOff(this.useCuttOff);
        ex.applyPositionRules(this.applyPosRuel);

    }


//    Invoke method String[] getTopN(int n, String txt, boolean ar) to get the
//    top n keyphrases from the input text. In this method, n is the number of desired keyphrases, txt is the
//    input from which to extract the keyphrases, and ar, is a flag that indicates whether the input is Arabic is
//    Arabic or not. For Arabic input this flag should be set to true. The returned strings are sorted by weight,
//    meaning that the string at postion [0], is the highest ranking keyphrase. If n is greater than the number
//    of keys generated, then only the keys generated keys will be returned.

    public String[] getNkeyPhrases(){

        String [] topKeys = this.extractor.getTopN(this.n,this.text,this.ArLanguage);
        return  topKeys;

    }

}
