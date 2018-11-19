package base;


import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import utils.Screenshots;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: habin,
 * created on: 26/09/18 : 3:44 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Log4j2

public class TestBase {
    private static Map verificationFailureMap = new HashMap();
    private WebDriver driver;

    public static List getVerificationFailures() {
        List verificationFailures = (List) verificationFailureMap.get(Reporter.getCurrentTestResult());
        return verificationFailures == null ? new ArrayList() : verificationFailures;
    }

    private void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private void assertTrue(boolean condition) {

        Assert.assertTrue(condition);
    }

    private void assertFalse(boolean condition) {

        Assert.assertFalse(condition);
    }

    private void assertEquals(Object actual, Object expected) {

        Assert.assertEquals(actual, expected);
    }

    public void verifyTrue(boolean condition, WebDriver driver) {
        setDriver(driver);
        try {
            assertTrue(condition);
        } catch (Throwable throwable) {
            addVerificationFailure(throwable);
        }
    }

    public void verifyFalse(boolean condition, WebDriver driver) {
        setDriver(driver);
        log.info("Verifying False: " + condition);
        try {
            assertFalse(condition);
        } catch (Throwable throwable) {
            addVerificationFailure(throwable);
        }
    }

    public void verifyEquals(Object actual, Object expected, WebDriver driver) {
        this.driver = driver;
        try {
            log.info("Comparing actual value: " + actual + " with expected value: " + expected);
            assertEquals(actual, expected);
        } catch (Throwable throwable) {
            log.error("FAILED comparing actual value: " + actual + " with expected value: " + expected);
            addVerificationFailure(throwable);
        }
    }

    private void addVerificationFailure(Throwable throwable) {
        Screenshots screenshots = new Screenshots(this.driver);
        screenshots.takeScreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
        List verificationFailures = getVerificationFailures();
        verificationFailureMap.put(Reporter.getCurrentTestResult(), verificationFailures);
        verificationFailures.add(throwable);
    }
}
