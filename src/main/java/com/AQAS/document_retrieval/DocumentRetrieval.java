package com.AQAS.document_retrieval;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentRetrieval {


    private ArrayList<String> _getLinksOnePage(String generatedSearchURL, Website website) {
        Document doc = null;
        try {
            doc = Jsoup.connect(generatedSearchURL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements newsHeadlines = doc.select(website.selector);

        String result = newsHeadlines.toString();


        //regex to extract links
        Pattern urlPattern = Pattern.compile(
                website.regex,
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

    /*
        generic function to get documents links
     */
    public ArrayList<String> getLinks(Website website, HashMap<String,Object> searchAttr) {
        ArrayList<String> allLinks = new ArrayList<String>();
        for (int i = 0; i <= (Integer)searchAttr.get("searchNumOfPages"); i++) {
            String generatedSearchURL = website.searchLink + (String)searchAttr.get("searchQuery") + "&" + website.pageVariableName + "=" + i;
            allLinks.addAll(_getLinksOnePage(generatedSearchURL,website));
        }
        return allLinks;
    }
}
