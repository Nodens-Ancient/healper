package bot.userinterface;

import bot.baseElements.BaseInterface;
import bot.elements.Button;
import models.apiModel.InventoryModel;
import models.apiModel.ItemFromInventoryModel;
import models.interfaces.EmojInterface;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import java.util.ArrayList;

public class InventoryMenu extends BaseInterface {

    public InlineKeyboardMarkup getMenu(InventoryModel inventory) {
        ArrayList<Button> result = new ArrayList<>();
        for (int i = 0; i < inventory.getItems().size(); i++) {
            ItemFromInventoryModel item = inventory.getItems().get(i);
            if (!item.isStatTrack()) {
                try {
                    result.add(new Button(EmojInterface.getTextWithEmojieSurround(String.format("%.20s |%s%5.2fRUB",
                            item.getName().replaceAll("\\(.+", ""), priceEmoji,
                            Double.parseDouble(item.getPrice()) / 100), emojiSellAll),
                            String.format("SELL@%s|%s", item.getUi_id(), item.getPrice())));
                } catch (Exception e) {
                    result.add(new Button(EmojInterface.getTextWithEmojieSurround(
                            item.getName(), stopEmoji), "INVENTORY"));
                }
            }
        }
        return new InlineKeyboardMarkup()
                .setKeyboard(createButtons(result));
    }
}
