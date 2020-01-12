package bot.message.commands;

import api.market.RestApi;
import api.market.enums.RequestEnums;
import framework.utils.ModelGenerator;
import models.apiModel.BalanceModel;
import models.apiModel.InventoryModel;
import models.apiModel.ItemFromInventoryModel;
import models.apiModel.ItemOnSell;
import models.interfaces.EmojInterface;
import models.users.UserModel;

import java.util.Objects;

public class CsGoMarket implements EmojInterface {
    private RestApi restApi;
    private UserModel user;

    public CsGoMarket(UserModel user) {
        this.user = user;
        restApi = new RestApi(user.getApiCode());
    }

    public InventoryModel getInventory() {
        InventoryModel inventory = restApi.getResult(RequestEnums.INVENTORY, InventoryModel.class);
        inventory.updatePriceOfAllItems(this);
        return inventory;
    }

    public ItemOnSell[] getIteemsOnSell() {
        return restApi.getResult(RequestEnums.ITEMS_ON_SALEE, ItemOnSell[].class);
    }

    public String getPriceOfItem(ItemFromInventoryModel item) {
        return restApi.getLowestPrice(item);
    }

    public String getBalance() {
        return EmojInterface.getTextWithEmojieSurround(
                Objects.requireNonNull(ModelGenerator.getModelByMappingWithKey(RequestEnums.BALANCE, user.getApiCode(), BalanceModel.class)).getBalance(), emojiMoney);
    }

    public String setOffline() {
        restApi.execute(RequestEnums.OFFLINE);
        return EmojInterface.getTextWithEmojieSurround("SWITCHED TO OFFLINE", emojiStateOffline);
    }

    public String setOnline() {
        restApi.execute(RequestEnums.ONLINE);
        return EmojInterface.getTextWithEmojieSurround("SWITCHED TO ONLINE", emojiStateOnline);
    }

    public String sellItem(String params) {
        restApi.setPrice(params);
        return EmojInterface.getTextWithEmojieSurround("ITEM HAS BEEN LISTED", doneEmoji);
    }

    public String clearSellingList() {
        restApi.execute(RequestEnums.DELETE_ALL);
        return EmojInterface.getTextWithEmojieSurround("ITEM HAS REMOVED FROM SELLING LIST", stopEmoji);
    }

    public void createTradeOffer() {
        restApi.execute(RequestEnums.CREATE_TRADE);
    }

    public String browseInventory() {
        StringBuilder stringBuilder = new StringBuilder();
        for (ItemFromInventoryModel item : getInventory().getItems()) {
            stringBuilder.append(emojiInventory).append(item.getName()).append("\n");
        }
        return stringBuilder.toString();
    }
}
