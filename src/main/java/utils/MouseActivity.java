package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private WebDriver driver;
    private Actions actions;
    private static final Logger log = LogManager.getLogger(MouseActivity.class.getName());


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

    public void performSendKeys(WebElement element, Object text){
        actions.moveToElement(element).click().sendKeys((CharSequence) text).perform();
    }

    public void performDoubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void performDoubleClickEnterText(WebElement element, CharSequence text) {
        int count = 0;
        while (count < 4) {
            try {
                actions.doubleClick(element).doubleClick(element).sendKeys(text).perform();
                count += 4;
            } catch (Exception e) {
                log.error(e.getMessage());
                count++;
            }

        }

    }

}
