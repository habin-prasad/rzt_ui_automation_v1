package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * author: habin,
 * created on: 25/09/18 : 6:00 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class WaitEx {
    protected static final Logger log = LogManager.getLogger(WaitEx.class.getName());
    private WebDriver driver;

    public WaitEx(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement waitElement(By locator, int timeout) {
        log.info("Waiting for element to be visible by locator: " + locator + " with timeout: " + timeout);
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return element;
    }

    public WebElement waitForElementToBeClickable(By locator, int timeout) {
        log.info("Waiting for element to be clickable by locator: " + locator + " with timeout: " + timeout);
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);

            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return element;
    }

    public WebElement ifElementPresentInDOM(By locator, int timeOut) {
        log.info("Waiting for element to be present in DOM by locator: " + locator + " with timeout: " + timeOut);
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return element;
    }

}
