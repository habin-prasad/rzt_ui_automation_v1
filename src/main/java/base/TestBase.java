package base;


import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: habin,
 * created on: 26/09/18 : 3:44 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class TestBase {

    private static Map verificationFailureMap = new HashMap();

    public static void assertTrue(boolean condition) {
        Assert.assertTrue(condition);
    }

    public static void assertFalse(boolean condition) {
        Assert.assertFalse(condition);
    }

    public static void assertEquals(Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
    }

    public static void verifyTrue(boolean condition){
        try {
            assertTrue(condition);
        } catch (Throwable throwable) {
            addVerificationFailure(throwable);
        }
    }
    public static void verifyFalse(boolean condition){
        try {
            assertFalse(condition);
        } catch (Throwable throwable) {
            addVerificationFailure(throwable);
        }
    }

    public static void verifyEquals(Object actual, Object expected) {
        try {
            assertEquals(actual, expected);
        } catch (Throwable throwable) {
            addVerificationFailure(throwable);
        }
    }

    public static void addVerificationFailure(Throwable throwable) {
        List verificationFailures = getVerificationFailures();
        verificationFailureMap.put(Reporter.getCurrentTestResult(), verificationFailures);
        verificationFailures.add(throwable);
    }

    public static List getVerificationFailures() {
        List verificationFailures = (List) verificationFailureMap.get(Reporter.getCurrentTestResult());
        return verificationFailures == null ? new ArrayList() : verificationFailures;
    }
}
