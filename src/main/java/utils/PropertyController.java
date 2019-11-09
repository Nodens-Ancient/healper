package utils;


import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class PropertyController {
    private static File file = new File("src/main/resources/parcels.properties");
    public static String getValueByKey(String key) throws IOException {
        InputStream input = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(input);
        input.close();
        return prop.getProperty(key);
    }

    public static Set<String> getNames() throws IOException {
        InputStream input = new FileInputStream(file);
        Properties prop = new Properties();
        prop.load(input);
        input.close();
        return prop.stringPropertyNames();
    }


    public static void deleteByKey(String key) throws IOException {
        Scanner scannerFile = new Scanner(file);
        StringBuilder stringBuilder = new StringBuilder();
        while (scannerFile.hasNextLine()) {
            String line = scannerFile.nextLine();
            if (!(line.split("=")[0]).equals(key)) {
                stringBuilder.append(line).append('\n');
            }
        }
        FileOutputStream out = new FileOutputStream(file);
        out.write(stringBuilder.toString().getBytes());
        scannerFile.close();
        out.close();
    }

    //    airpods=LB091514878SG;
//    nika=UM038922945JE;
    public static void addKeyAndValue(String key, String value) throws IOException {
        InputStream input = new FileInputStream(file);

        StringBuilder stringBuilder = new StringBuilder();
        for (String name : getNames()) {
            if(!name.equals(key)){
                stringBuilder.append(name).append("=").append(getValueByKey(name)).append('\n');
            }
        }
        FileWriter writer = new FileWriter(file);
        stringBuilder.append(key).append("=").append(value).append('\n');
        writer.write(stringBuilder.toString());
        writer.flush();
        writer.close();
        input.close();
    }
}
