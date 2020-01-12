package bot.userinterface;

import api.market.RestApi;
import bot.baseElements.BaseInterface;
import bot.elements.Button;
import models.apiModel.InventoryModel;
import models.apiModel.ItemOnSell;
import models.interfaces.EmojInterface;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.ArrayList;

public class ItemOnSellMenu extends BaseInterface implements EmojInterface{

    public InlineKeyboardMarkup getMenu(ItemOnSell[] itemOnSell) {
        ArrayList<Button> result = new ArrayList<>();
        for (ItemOnSell item : itemOnSell) {
            try {
                result.add(new Button(EmojInterface.getTextWithEmojieSurround(String.format("%.5s |%s%4.2fRUB\n%s",
                        item.getIMarketHashName().replaceAll("\\(.+", ""), priceEmoji,
                        item.getUiPrice(), item.getPosition()), pinEmoji), "STUB@"));
            } catch (NullPointerException e) {
                result.add(new Button(EmojInterface.getTextWithEmojieSurround(
                        item.getIMarketHashName(), stopEmoji), "INVENTORY"));
            }

        }
        return new InlineKeyboardMarkup()
                .setKeyboard(createButtons(result));
    }
}
