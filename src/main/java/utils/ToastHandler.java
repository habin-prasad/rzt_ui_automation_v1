package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author: habin,
 * created on: 26/09/18 : 6:43 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class ToastHandler {
    private WebDriver driver;

    @FindBy(xpath = "//div[@type='error']//span[contains(.,'OK')]")
    private WebElement errorToastOKButton;

    public ToastHandler(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptToast(String type) {
        if (type.equalsIgnoreCase("error"))
            errorToastOKButton.click();
        else if (type.equalsIgnoreCase("warning")) {
        } else if (type.equalsIgnoreCase("accept")) {
        }
    }

    public boolean isToastPresent(By by) {

        try {
            driver.findElements(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }

    }
}
