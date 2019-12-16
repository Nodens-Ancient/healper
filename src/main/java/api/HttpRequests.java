package api;

import utils.PropertyController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public interface HttpRequests {
    default String request(String body) {
        String line = null;
        try {
            URL url = new URL(body + System.getenv("keyAPI"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            line = rd.readLine();
            rd.close();
        } catch (Exception ignored){
        }
        return line;
    }
}
