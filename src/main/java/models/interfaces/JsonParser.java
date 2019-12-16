package models.interfaces;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public interface JsonParser {

    default String parserById(String task, String id, String parameter) {
        JSONArray data;
        String result = null;
        try {
            data = getData(task);
            for (Object datum : data) {
                if (((JSONObject) datum).get("ui_id").equals(id)) {
                    result = ((JSONObject) datum)
                            .get(parameter).toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    default String getParameter(String task, String target) {
        try {
            return ((JSONObject)new JSONParser().parse(task))
                    .get(target).toString();
        } catch (Exception ignored) {
        }
        return null;
    }

    default ArrayList<String> getIdList(String task) {
        JSONArray data;
        ArrayList<String> result = new ArrayList<>();
        try {
            data = getData(task);
            for (Object item : data) {
                result.add(((JSONObject) item).get("ui_id").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    default JSONArray getData(String task) throws ParseException {
        return ((JSONArray) ((JSONObject)new JSONParser().parse(String.valueOf(task)))
                .get("data"));
    }
}
