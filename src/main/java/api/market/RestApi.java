package api.market;

import api.HttpRequests;
import models.InventoryItem;
import models.interfaces.JsonParser;

import java.util.ArrayList;

public class RestApi implements HttpRequests, JsonParser {

    public String getBalance() {
        return String.valueOf(Double.parseDouble(
                request("https://market.csgo.com/api/GetMoney/?key=")
                        .replaceAll("[^0-9]", ""))/100);
    }

    public  void goOnline() {
        request("https://market.csgo.com/api/PingPong/?key=");
    }

    public  void goOffLine() {
        request("https://market.csgo.com/api/GoOffline/?key=");
    }

    public  String setPrice(String inventoryClass, String price) {
        return request(String.format("https://market.csgo.com/api/SetPrice/%s/%s/?key=",
                inventoryClass, price));
    }

    public String getTradeStatus() {
        return request("https://market.csgo.com/api/MarketTrades/?key=");
    }

    public ArrayList<InventoryItem> getInventory() {
        ArrayList<InventoryItem> result = new ArrayList<>();
        for (String id : getIdList(request("https://market.csgo.com/api/GetInv/?key="))) {
            result.add(new InventoryItem(id));
        }
        return result;
    }

    public void deleteAllSales() {
        request("https://market.csgo.com/api/RemoveAll/?key=");
    }

    public String getLowestPrice(String classId, String instanceId) {
        return getParameter(request(String
                .format("https://market.csgo.com/api/BestSellOffer/%s_%s/?key=", classId, instanceId))
                , "best_offer");
    }
}
