package pages.admin;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
class LicenceAndUsage {

    @FindBy(xpath = "//a[@href='/settings/license']")
    private WebElement clickLicenseandUsage;


    @FindBy(xpath = "//button[@title='']/span")
    private WebElement maximiseGraphIcon;

    @FindBy(xpath = "//button[@title='Close Popup']/span")
    private WebElement closePopup;

    @FindBy(xpath = "//a[@href='/settings/license/usage']/button[@title='Tabular View']/span")
    private WebElement tabularForm;


}
