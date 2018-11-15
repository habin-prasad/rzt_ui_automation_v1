package utils;

import base.TestBase;
import org.openqa.selenium.WebDriver;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * author: habin,
 * created on: 25/09/18 : 6:08 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Validations extends TestBase {

    public void validateTitle(String expected, String actual, WebDriver driver) {
        verifyEquals(actual, expected, driver);
    }

    public boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            log.error(ex.getMessage());
            result = false;
        }
        return result;
    }


}
