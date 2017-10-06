package com.AQAS.document_retrieval;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.*;

public final class HelpersD {

    public static WebDriver driver;

    public static ArrayList<Website_Document> removeDuplicatesFromDocumentLinks(ArrayList<Website_Document> websiteDocuments,
                                                                                String[] listOfWebsitesToApplyOn) {

        for(String sourceWebsite:listOfWebsitesToApplyOn ){
            ArrayList<String> allLinksTocheckDuplicates = new ArrayList<String>();
            int index = 0;
            int websiteIndex = 0;
            for(Website_Document websiteDocument:websiteDocuments){
                if(!sourceWebsite.equals(websiteDocument.sourceWebsite)){
                    allLinksTocheckDuplicates.addAll(websiteDocument.DocumentLinks);
                }
                else{
                    websiteIndex = index;
                }
                index++;
            }
            websiteDocuments.get(websiteIndex).removeDuplicatedDocumentLinks(allLinksTocheckDuplicates);
        }

        return websiteDocuments;

    }

    public static void openWebDriver() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir") + "/exec/phantomjs.exe");
        driver = new PhantomJSDriver(caps);

    }

    public static void closeWebDriver() {

        driver.close();
    }




}
