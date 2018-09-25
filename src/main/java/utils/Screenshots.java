package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author: habin,
 * created on: 25/09/18 : 6:01 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class Screenshots {
    WebDriver driver;

    public Screenshots(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String fileName) {
        String directoryName = System.getProperty("user.dir") + "/TestScreenshots/";
        Date date = new Date();

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(directoryName + fileName + date.getTime() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
