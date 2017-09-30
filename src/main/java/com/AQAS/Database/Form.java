package com.AQAS.Database;

import java.util.ArrayList;

public class Form {

    int id;
    int query_id;
    String text;


    public Form(int query_id, String text) {
        this.query_id = query_id;
        this.text = text;
    }


    public void insertForm() {

    }

    public static Form getFormById(int id) {
        return null;
    }

    public ArrayList<Document> getFormsDocuments()
    {
        return null;
    }
}
