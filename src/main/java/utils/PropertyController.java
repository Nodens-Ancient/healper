package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyController {

    public static String getValue(String key) throws IOException {
        InputStream input = new FileInputStream("src/main/resources/parcels.properties");
        Properties prop = new Properties();
        prop.load(input);
        return prop.getProperty("airpods");
    }
}
