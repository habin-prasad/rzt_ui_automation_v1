package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

/**
 * @author: habin,
 * created on: 25/09/18 : 6:08 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Validations {
    WebDriver driver;
    SoftAssert softAssert;

    public Validations(WebDriver driver){
        this.driver = driver;
        softAssert = new SoftAssert();
    }

    public void validateTitle(String expected,String actual){
//        System.out.println(expected +":"+actual);
         softAssert.assertEquals(actual,expected);
    }
}
