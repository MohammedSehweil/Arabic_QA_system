package com.document_retrieval.zma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Iterator;
import java.util.List;

public class SeleniumTests {


    public static void main(String[] args) {


        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY ,System.getProperty("user.dir") + "/exec/phantomjs.exe" );
        WebDriver driver = new PhantomJSDriver(caps);

        // And now use this to visit Google
        driver.get("https://www.webteb.com/search?q=%D8%A7%D9%84%D8%B3%D9%83%D8%B1%D9%8Aالسكري");


        List<WebElement> refList = driver.findElements(By.cssSelector("div.gsc-table-cell-thumbnail a.gs-title"));
        System.out.println(refList.size());

        //to remove null (elements that have the selector but doesn't have href)
        Iterator<WebElement> i = refList.iterator();
        while (i.hasNext()) {
            WebElement s = i.next(); // must be called before you can call i.remove()
            if(s.getAttribute("href") == null)
                i.remove();
        }
        for (WebElement we: refList ) {
            System.out.println(we.getAttribute("href"));
        }
        //Close the browser
        driver.quit();

    }
}
