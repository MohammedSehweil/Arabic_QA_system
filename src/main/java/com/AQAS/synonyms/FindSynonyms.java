package com.AQAS.synonyms;

import java.util.ArrayList;
import java.util.List;

public class FindSynonyms
{
    private String word;

    public FindSynonyms(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<String> wordSynset(){
        ArrayList<String> SynsetList = new ArrayList<>();
        AWN awn=new AWN ("src/main/java/com/AQAS/synonyms/awn.xml",false);
        List<String> listWordId= awn.Get_List_Word_Id_From_Value(this.word);
        for(int i = 0; i< listWordId.size();i++){
            System.out.println("Word ID: " + listWordId.get(i) +" Word Value: " + awn.Get_Word_Value_From_Word_Id(listWordId.get(i)));
            String SynsetID= awn.Get_Synset_ID_From_Word_Id(listWordId.get(i));
            List<String> listWordIdFromSynsent=awn.Get_List_Word_Id_From_Synset_ID(SynsetID);
            for(int j = 0; j< listWordIdFromSynsent.size();j++) {
                String wordValue = awn.Get_Word_Value_From_Word_Id(listWordIdFromSynsent.get(j));
                SynsetList.add(wordValue);
            }
        }
        return SynsetList;
    }
}
