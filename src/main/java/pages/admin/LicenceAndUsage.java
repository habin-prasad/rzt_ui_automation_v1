package pages.admin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LicenceAndUsage {

    @FindBy(xpath = "//a[@href='/settings/license']")
    private WebElement clickLicenseandUsage;


    @FindBy(xpath = "//button[@title='']/span")
    private WebElement maximiseGraphIcon;

    @FindBy(xpath = "//button[@title='Close Popup']/span")
    private WebElement closePopup;

    @FindBy(xpath = "//a[@href='/settings/license/usage']/button[@title='Tabular View']/span")
    private WebElement tabularForm;


}
