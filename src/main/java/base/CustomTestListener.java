package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.util.List;

/**
 * @author: habin,
 * created on: 26/09/18 : 4:03 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class CustomTestListener extends TestListenerAdapter {

    private static final Logger log = LogManager.getLogger(CustomTestListener.class.getName());

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        Reporter.setCurrentTestResult(testResult);
        if (method.isTestMethod()) {
            List verificationFailures = TestBase.getVerificationFailures();
            if (verificationFailures.size() > 0) {
                testResult.setStatus(ITestResult.FAILURE);

                if (testResult.getThrowable() != null) {
                    verificationFailures.add(testResult.getThrowable());
                }
                int size = verificationFailures.size();

                if (size == 1) {
                    testResult.setThrowable((Throwable) verificationFailures.get(0));
                    log.error("Failure encountered: " + verificationFailures.get(0).toString());
                } else {
                    StringBuffer failureMessage = new StringBuffer("Multiple Failure (").append(size).append("):nn");
                    log.error("Multiple Failure (" + size + "):nn");
                    for (int i = 0; i < size - 1; i++) {
                        failureMessage.append("Failure ").append(i + 1).append(" of ").append(size).append(":nn");
                        log.error("Failure " + i + 1 + " of " + size + ":nn");
                        Throwable t = (Throwable) verificationFailures.get(i);
                        String fullStackTrace = Utils.stackTrace(t, false)[1];
                        failureMessage.append(fullStackTrace).append(":nn");
                    }

                    Throwable last = (Throwable) verificationFailures.get(size - 1);
                    failureMessage.append("Failure ").append(size).append(" of ").append(size).append(":nn");
                    log.error("Failure " + size + " of " + size + ":nn");
                    failureMessage.append(last.toString());

                    Throwable merged = new Throwable(failureMessage.toString());
                    merged.setStackTrace(last.getStackTrace());

                    testResult.setThrowable(merged);
                }

            }
        }
    }


    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Successfully Completed ");
    }
}
