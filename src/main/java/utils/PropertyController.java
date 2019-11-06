package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class PropertyController {

    public static String getValueByKey(String key) throws IOException {
        InputStream input = new FileInputStream("src/main/resources/parcels.properties");
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty(key);
    }

    public static Set<String> getNames() throws IOException {
        InputStream input = new FileInputStream("src/main/resources/parcels.properties");
        Properties prop = new Properties();
        prop.load(input);
        return prop.stringPropertyNames();
    }

    public static void deleteByKey(String key) throws IOException {
        InputStream input = new FileInputStream("src/main/resources/parcels.properties");
        Properties prop = new Properties();
        prop.load(input);
        prop.remove(key);
    }

    public static void addKeyAndValue(String key, String value) throws IOException {
        InputStream input = new FileInputStream("src/main/resources/parcels.properties");
        Properties prop = new Properties();
        prop.load(input);
        prop.setProperty(key, value);
    }
}
