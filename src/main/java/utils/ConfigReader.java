package utils;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    public static String get(String key, String fileName) {
        if (properties == null) loadProperties(fileName);
        return properties.getProperty(key);
    }

    private static void loadProperties(String propertiesFileName) {
        try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(propertiesFileName)) {
            if (input == null) throw new RuntimeException("config.properties not found on classpath");
            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }
}