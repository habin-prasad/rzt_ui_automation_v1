package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * author: habin,
 * created on: 27/09/18 : 11:01 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class BrokenLinksVerify {
    private static final Logger log = LogManager.getLogger(BrokenLinksVerify.class.getName());
    private WebDriver driver;

    public BrokenLinksVerify(WebDriver driver) {
        this.driver = driver;
    }

    public void testBrokenLinks() {
        List<WebElement> linksList = clickableLinks();
        for (WebElement e : linksList) {
            String href = e.getAttribute("href");
            try {
                String responseCode = linkStatus(new URL(href));
                if (responseCode.charAt(0) == '2' || responseCode.charAt(0) == '3')
                    log.info("URL: " + href + " Status: " + responseCode);
                else
                    log.error("URL: " + href + " Status: " + responseCode);
            } catch (Exception exception) {
                log.error(exception.getMessage());
            }
        }
    }


    private List<WebElement> clickableLinks() {
        List<WebElement> linksToClick = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        elements.addAll(driver.findElements(By.tagName("img")));

        for (WebElement e : elements) {
            if (e.getAttribute("href") != null) {
                linksToClick.add(e);
            }
        }
        return linksToClick;
    }


    private String linkStatus(URL url) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            String response = String.valueOf(httpURLConnection.getResponseCode());
            httpURLConnection.disconnect();
            return response;
        } catch (Exception e) {
            return e.getMessage();
        }
    }


}
