package com.AQAS.document_retrieval;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import static com.AQAS.document_retrieval.HelpersD.driver;
import static com.AQAS.document_retrieval.HelpersD.removeDuplicatesFromDocumentLinks;

public class DocumentRetrieval {

    public static ArrayList<Website_Document> getLinksOfAllWebsitesByQuery(String query, int searchNumOfPages) {
        ArrayList<Website_Document> DocumentSLinksWithContentSelctor = new ArrayList<Website_Document>();
        HashMap<String, Object> searchAttr = new HashMap<String, Object>();
        searchAttr.put(ConfigD.Keys.searchQuery, query);
        searchAttr.put(ConfigD.Keys.searchNumOfPages, searchNumOfPages);
        for (Website website : ConfigD.webSites) {
            try {
                DocumentSLinksWithContentSelctor.add(website.extractDocumentsLinksForAllPages(searchAttr));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return removeDuplicatesFromDocumentLinks(DocumentSLinksWithContentSelctor,ConfigD.websitesToremoveDuplicatesFrom);
    }


    /**
     * @param URL
     */
    public static String retrieveDocumentText(String URL , String contentSelector) {
        driver.get(URL);
        try {
            WebElement showMoreButton = driver.findElement(By.className("showMore"));
            showMoreButton.click();
        } catch (Exception e) {
        }
        WebElement we;
        try {
             we = driver.findElement(By.cssSelector(contentSelector));
        }
        catch (Exception e){
            we = driver.findElement(By.tagName("body"));
        }


        String documentText = we.getText();
        return documentText;

    }


}
