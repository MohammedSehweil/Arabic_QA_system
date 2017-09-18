package com.exmaple.aqs;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentRetrieval {


    public ArrayList<String> getDoctooriLinksOnePage(String searchQuery, int page) {
        Document doc = null;
        try {
            doc = Jsoup.connect("http://www.doctoori.net/search/?word=" + searchQuery + "&pg=" + page).get();

//            System.out.println("http://www.doctoori.net/search/?word=" + searchQuery + "&pg=" + page);

        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsHeadlines = doc.select(".content-main a.btn-primary");

        String result = newsHeadlines.toString();


        //regex to extract links
        Pattern urlPattern = Pattern.compile(
                "href=\"([^\"]*)\"",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        Matcher matcher = urlPattern.matcher(result);

        ArrayList<String> links = new ArrayList<String>();
        while (matcher.find()) {
            int matchStart = matcher.start(1);
            int matchEnd = matcher.end();
            links.add(result.substring(matchStart, matchEnd - 1));
            System.out.println(result.substring(matchStart, matchEnd - 1));

            // now you have the offsets of a URL match
        }
        return links;
    }

    public ArrayList<String> getDoctooriLinks(String searchQuery, int numPages) {
        ArrayList<String> allLinks = new ArrayList<String>();
        for (int i = 0; i <= numPages; i++) {
            allLinks.addAll(getDoctooriLinksOnePage(searchQuery, i));
        }

        return allLinks;
    }
}
