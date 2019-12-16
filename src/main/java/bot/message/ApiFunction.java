package bot.message;

import api.market.RestApi;
import models.interfaces.EmojInterface;
import models.InventoryItem;

public class ApiFunction implements EmojInterface {
    private static RestApi restApi = new RestApi();
    public static String getBalance() {
        return EmojInterface.getTextWithEmojieSurround(restApi.getBalance(), emojiMoney);
    }

    public static String setOffline() {
        restApi.goOffLine();
        return EmojInterface.getTextWithEmojieSurround("SWITCHED TO OFFLINE", emojiStateOffline);
    }

    public static String setOnline() {
        restApi.goOnline();
        return EmojInterface.getTextWithEmojieSurround("SWITCHED TO ONLINE", emojiStateOnline);
    }

    public static String sellItem(String id) {
        new InventoryItem(id).sellItem();
        return EmojInterface.getTextWithEmojieSurround("ITEM HAS BEEN LISTED", doneEmoji);
    }

    public static String clearSellingList() {
        restApi.deleteAllSales();
        return EmojInterface.getTextWithEmojieSurround("ITEM HAS REMOVED FROM SELLING LIST", stopEmoji);
    }

    public static String browseInventory() {
        StringBuilder stringBuilder = new StringBuilder();
        for (InventoryItem inventoryItem : restApi.getInventory()) {
            stringBuilder
                    .append(inventoryItem.getName())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
