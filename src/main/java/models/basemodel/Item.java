package models.basemodel;

import api.HttpRequests;
import lombok.Data;
import models.interfaces.EmojInterface;
import models.interfaces.JsonParser;
@Data
public class Item implements JsonParser, HttpRequests, EmojInterface {
    String name;
    String id;
    String taskApi;

    String classId;
    String instanceId;

    public Item(String id, String taskApi) {
        this.id = id;
        this.taskApi = taskApi;
        name = parserById(request(taskApi), id, "i_market_hash_name");

        classId = parserById(request(taskApi), id, "i_classid");
        instanceId = setInstance();
    }

    private String setInstance() {
        if(parserById(request(taskApi), id, "i_instanceid").equals("188531839")) {
            return "188530170";
        }
        return parserById(request(taskApi), id, "i_instanceid");
    }

    private String selectType() {
        String he_name = parserById(request(taskApi), id, "he_name");
        switch (he_name) {
            case "Нож":
                return knife;
            case "Пистолет-пулемёт":
                return emojiInventory;
            case "Пистолет":
                return pistol;
            default:
                return he_name;
        }
    }
}
