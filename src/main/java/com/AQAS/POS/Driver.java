package com.AQAS.POS;

import javafx.util.Pair;

import java.util.ArrayList;

public class Driver {
    public static void main(String arg[])
    {

        StanfordPOS pos = new StanfordPOS("ما هي أعراض مرض السكري مدرسة امريكا فلسطين محمد اسيل يقتل ينتقد هرب من المشاكل");
        ArrayList<Pair<String,String>> returnPOS = pos.tokenPOS();

        for(int i =0; i< returnPOS.size(); i++){
            Pair<String,String> POS_pair = returnPOS.get(i);
            String word = POS_pair.getKey();
            String word_pos = POS_pair.getValue();
            System.out.println("POS for word "+ word +" is " + word_pos);
        }
    }
}
