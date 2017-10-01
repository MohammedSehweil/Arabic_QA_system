package com.AQAS.Database;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;

import static com.AQAS.Database.HelpersDB.props;

public class Form {

    int id;
    int question_id;
    String text;
    ArrayList<Document> documents;


    public Form() {
    }

    public Form(int id) {
        this.id = id;
    }

    public Form(String text) {
        this.text = text;
    }


    public int store() {
        try {
            org.jsoup.nodes.Document doc = Jsoup.connect(props.getProperty("LOCAL_SERVER_IP") + "forms/" + this.question_id)
                    .data("text", this.text)
                    .userAgent("Mozilla")
                    .post();
            return Integer.parseInt(doc.text());

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static Form getFormById(int id) {
        return null;
    }

    public ArrayList<Document> getDocuments() {
        try {
            System.out.println(this.id);
            String json = Jsoup.connect(props.getProperty("LOCAL_SERVER_IP") + "/forms/document/" + this.id).ignoreContentType(true).execute().body();
            System.out.println(json);
            return null;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
