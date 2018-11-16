package utils;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * author: habin,
 * created on: 26/09/18 : 6:43 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Slf4j
public class ToastHandler {
    //    protected static final Logger log = LogManager.getLogger(ToastHandler.class.getName());
    private WebDriver driver;

    @FindBy(xpath = "//div[@type='error']//span[contains(.,'OK')]")
    private WebElement errorToastOKButton;

    @FindBy(css = "button[title='Ok']")
    private WebElement okConfirmationBoxButton;

    @FindBy(css = "button[title='Cancel']")
    private WebElement cancelConfirmationBoxButton;

    @FindBy(xpath = "//div[@type='error']//span[contains(.,'OK')]")
    private WebElement errorToast;

    @FindBy(xpath = "//span[starts-with(@class,'flaticon-error')]/parent::*/span[starts-with(@class,'Text')]")
    private WebElement toastMessage;

    public ToastHandler(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void acceptToast(String type) {
        if (type.equalsIgnoreCase("error")) {
            log.info("Clicking on Error Toast Ok button.");
            errorToastOKButton.click();
        }
        else if (type.equalsIgnoreCase("warning")) {
            log.info("Clicking on Warning Toast Ok button.");
        } else if (type.equalsIgnoreCase("accept")) {
            log.info("Clicking on Accept Toast Ok button.");
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

    public void clickOkButton() {
        log.info("Clicking on Confirmation Ok button.");
        okConfirmationBoxButton.click();
    }

    public void clickCancelButton() {
        log.info("Clicking on Confirmation Cancel button.");
        cancelConfirmationBoxButton.click();
    }

    public boolean isErrorToastPresent() {
        return errorToast.isDisplayed();
    }

    public String getErrorMessage() {
        return toastMessage.getText();
    }

//    public void clickerrorOkButton() {
//        log.info("Clicking on Error Toast Ok button.");
//        errorToastOKButton.click();
//    }
}
