package base;

import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * author: habin,
 * created on: 26/09/18 : 4:03 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Slf4j
public class CustomTestListener extends TestListenerAdapter {

//    private static final Logger log = LogManager.getLogger(CustomTestListener.class.getName());

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        String msgStrt = "Failure ";
        Reporter.setCurrentTestResult(testResult);
        if (method.isTestMethod()) {
            List<Throwable> verificationFailures = (List<Throwable>) TestBase.getVerificationFailures();
            if (!verificationFailures.isEmpty()) {
                testResult.setStatus(ITestResult.FAILURE);

                if (testResult.getThrowable() != null) {
                    verificationFailures.add(testResult.getThrowable());
                }
                int size = verificationFailures.size();

                if (size == 1) {
                    testResult.setThrowable(verificationFailures.get(0));
                    log.error("Failure encountered: " + verificationFailures.get(0).toString());
                } else {
                    StringBuffer failureMessage = new StringBuffer("Multiple Failure (").append(size).append("):nn");
                    log.error("Multiple Failure (" + size + "):nn");
                    for (int i = 0; i < size - 1; i++) {
                        failureMessage.append(msgStrt).append(i + 1).append(" of ").append(size).append(":nn");
                        log.error(msgStrt + i + 1 + " of " + size + ":nn");
                        Throwable t = verificationFailures.get(i);
                        String fullStackTrace = Utils.stackTrace(t, false)[1];
                        failureMessage.append(fullStackTrace).append(":nn");
                    }

                    Throwable last = verificationFailures.get(size - 1);
                    failureMessage.append(msgStrt).append(size).append(" of ").append(size).append(":nn");
                    log.error(msgStrt + size + " of " + size + ":nn");
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
        log.info("Successfully Completed :" + result.getMethod() +
                " in time" + TimeUnit.MILLISECONDS.toSeconds(result.getEndMillis()
                - result.getStartMillis()) + "seconds");
    }
}
