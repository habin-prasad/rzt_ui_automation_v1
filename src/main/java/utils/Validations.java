package utils;

import base.TestBase;
import org.openqa.selenium.WebDriver;

/**
 * author: habin,
 * created on: 25/09/18 : 6:08 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Validations extends TestBase {

    public void validateTitle(String expected, String actual, WebDriver driver) {
        verifyEquals(actual, expected, driver);
    }


}
