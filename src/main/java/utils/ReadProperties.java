package utils;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

/**
 * author: habin,
 * created on: 27/09/18 : 3:25 PM
 * To change this template use File | Settings | File and Code Templates.
 */

@Slf4j
public class ReadProperties {
    private final Properties properties = new Properties();

    public ReadProperties(String resourceName) {
        final InputStream inputStream = getClass().getResourceAsStream(resourceName);
        try {
                properties.load(inputStream);
        } catch (final IOException e) {
            log.error(e.getMessage());
        }
    }

    public String getValue(final String key) {
        return properties.getProperty(key);
    }

    public boolean getBoolean(final String key) {
        return parseBoolean(getValue(key));
    }

    public int getInt(final String key) {
        return parseInt(getValue(key));
        }
    }


