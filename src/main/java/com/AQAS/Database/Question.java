package com.AQAS.Database;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

import static com.AQAS.Database.HelpersDB.props;

public class Question {

    int id;
    String text;
    ArrayList<Form> forms;


    public Question(String text, ArrayList<Form> forms) {
        this.text = text;
        this.forms = forms;
    }

    public int store() {
        try {
            Document doc = Jsoup.connect(props.getProperty("LOCAL_SERVER_IP") + "questions")
                    .data("text", this.text)
                    .userAgent("Mozilla")
                    .post();
            return Integer.parseInt(doc.text());

        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public Question get() {
        return null;
    }

    public ArrayList<Question> getForms() {
        return null;
    }
}
