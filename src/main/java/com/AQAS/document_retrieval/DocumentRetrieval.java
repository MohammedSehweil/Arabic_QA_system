package com.AQAS.document_retrieval;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.AQAS.document_retrieval.HelpersD.driver;

public class DocumentRetrieval {


    /**
     *
     * @param searchAttr
     * @return Array list for all links in all websites
     */
    public ArrayList<String> getLinksFromAllWebsites(HashMap<String, Object> searchAttr) {
        ArrayList<String> searchResultURLs = new ArrayList<String>();

        for (Website website : ConfigD.webSites) {
            try {
                searchResultURLs.addAll(website.getLinks(searchAttr));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //Close the browser

        return HelpersD.removeDuplicates(searchResultURLs);
    }

    /**
     *
     * @param URL
     */
    public static String retrieveDocumentText(String URL) {
        driver.get(URL);
        try {
            WebElement showMoreButton = driver.findElement(By.className("showMore"));
            showMoreButton.click();
        } catch (Exception e) {
        }

        WebElement we = driver.findElement(By.tagName("body"));


        String documentText = we.getText();
        return documentText;

    }


}
