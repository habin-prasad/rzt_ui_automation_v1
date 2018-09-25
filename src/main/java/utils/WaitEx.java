package utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author: habin,
 * created on: 25/09/18 : 6:00 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class WaitEx {
    WebDriver driver;

    public WaitEx(WebDriver driver){
        this.driver=driver;
    }

    public void waitElement(By locator, int timeout){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void waitForElement(By locator,int timeout){
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver,timeout);
            element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
