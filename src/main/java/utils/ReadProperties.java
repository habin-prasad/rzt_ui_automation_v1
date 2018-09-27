package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author: habin,
 * created on: 27/09/18 : 3:25 PM
 * To change this template use File | Settings | File and Code Templates.
 */


public class ReadProperties {
    private InputStream inputStream = null;
    private String propValue = "";

    public String getPropertyValue(String propKey) {
        try {
            String directoryName = System.getProperty("user.dir") + "/config/";
            Properties properties = new Properties();
            String propertyFileName = "application.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
//            inputStream = FileUtils.class.getResourceAsStream(propertyFileName);

            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new FileNotFoundException("property file " + propertyFileName + " not found at the location");
            }

            propValue = properties.getProperty(propKey);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return propKey;
    }

}
