package utils;

import lombok.extern.slf4j.Slf4j;
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

@Slf4j
public class WaitEx {
    private WebDriver driver;
    private String timeOutMsg = " with timeout in seconds : ";

    public WaitEx(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitElement(By locator, int timeoutInSeconds) {
        log.info("Waiting for element to be visible by locator: " + locator + timeOutMsg + timeoutInSeconds);
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return element;
    }

    public WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
        log.info("Waiting for element to be clickable by locator: " + locator + timeOutMsg + timeoutInSeconds);
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);

            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return element;
    }

    public WebElement ifElementPresentInDOM(By locator, int timeoutInSeconds) {
        log.info("Waiting for element to be present in DOM by locator: " + locator + timeOutMsg + timeoutInSeconds);
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return element;
    }

}
