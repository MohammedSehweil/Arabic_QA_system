package com.AQAS.document_retrieval;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentRetrieval {


    private ArrayList<String> _getLinksOnePage(String generatedSearchURL, Website website, WebDriver driver) {

        //GET request
        driver.get(generatedSearchURL);

        List<WebElement> refList = driver.findElements(By.cssSelector(website.selector));
        //to remove null (elements that have the selector but doesn't have href)
        Iterator<WebElement> i = refList.iterator();
        while (i.hasNext()) {
            WebElement s = i.next(); // must be called before you can call i.remove()
            if (s.getAttribute("href") == null)
                i.remove();
        }
        //store results in arrayLists
        ArrayList<String> links = new ArrayList<String>();
        for (WebElement we : refList) {
            String link = we.getAttribute("href");
            links.add(link);
        }
        return links;
    }

    /*
        generic function to get documents links
     */
    public ArrayList<String> getLinks(Website website, HashMap<String, Object> searchAttr, WebDriver driver) throws UnsupportedEncodingException {
        ArrayList<String> allLinks = new ArrayList<String>();

        int startPage = website.searchPageOffset;
        int endPage = (Integer) searchAttr.get("searchNumOfPages") + website.searchPageOffset;
        for (int i = startPage; i < endPage; i++) {
            System.out.println("Link Requested->"+website.generateSearchLink((String) searchAttr.get("searchQuery"),i));
            String generatedSearchURL = website.generateSearchLink((String) searchAttr.get("searchQuery"),i);
            allLinks.addAll(_getLinksOnePage(generatedSearchURL, website, driver));
        }
        return allLinks;
    }

    public ArrayList<String> getLinksFromAllWebsites(HashMap<String, Object> searchAttr) {

        WebDriver driver = Helpers.openWebDriver();

        ArrayList<String> searchResultURLs = new ArrayList<String>();

        for (Website website : Config.webSites) {
            try {
                searchResultURLs.addAll(getLinks(website, searchAttr, driver));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        //Close the browser
        Helpers.closeWebDriver(driver);

        return Helpers.removeDuplicates(searchResultURLs);
    }

    public void getDocument(String URL){
        WebDriver driver =Helpers.openWebDriver();
        driver.get(URL);
        try {
            WebElement showMoreButton = driver.findElement(By.className("showMore"));
            showMoreButton.click();
        }
        catch (Exception e){
        }

        WebElement we = driver.findElement(By.tagName("body"));

        System.out.println(we.getText());

        Helpers.closeWebDriver(driver);


    }


}
