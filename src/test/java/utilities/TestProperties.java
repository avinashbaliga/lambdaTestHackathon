package utilities;

import exceptions.FailedToInitialisePropertiesException;
import io.cucumber.java.BeforeAll;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public final class TestProperties {

    private static final String resourceFile = "src/main/resources/testConfig.properties";
    private static Properties properties = null;

    @BeforeAll
    public static void setProperties() {
        if (properties == null) {
            try {
                File file = new File(resourceFile);
                FileInputStream inputStream = new FileInputStream(file);
                properties = new Properties();
                properties.load(inputStream);
            } catch (IOException e) {
                throw new FailedToInitialisePropertiesException("Failed to load properties file. Please check if testConfig.properties file is present in: " + resourceFile);
            }

            loadProperties();
        }
    }

    private static void loadProperties() {
        Set<Object> keys = properties.keySet();

        for (Object key : keys) {
            System.setProperty(key.toString(), properties.getProperty(key.toString()));
        }
    }
}
