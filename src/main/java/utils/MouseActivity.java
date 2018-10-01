package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author: habin,
 * created on: 25/09/18 : 5:59 PM
 * To change this template use File | Settings | File and Code Templates.
 */
public class MouseActivity {
    WebDriver driver;
    Actions actions;

    public MouseActivity(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }

    public void perfomClick(WebElement element) {
        actions.moveToElement(element).click().perform();
    }

    public void selectElementByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

}
