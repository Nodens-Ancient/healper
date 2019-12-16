package bot.userinterface;

import api.market.RestApi;
import bot.baseElements.BaseInterface;
import bot.elements.Button;
import models.InventoryItem;
import models.interfaces.EmojInterface;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.util.ArrayList;

public class InventoryMenu extends BaseInterface {

    private String getName(String name) {
        return name.replaceAll("StatTrak™ ", "")
                .replaceAll(" \\|.+", "");
    }

    public InlineKeyboardMarkup getMenu() {
        ArrayList<InventoryItem> inventory = new RestApi().getInventory();
        Button[][] result = new Button[inventory.size()][1];
        for (int index = 0; index < inventory.size(); index++) {
            result[index][0] = new Button(EmojInterface.getTextWithEmojieSurround(String.format("%s |%s%5.2fRUB",getName(inventory.get(index).getName()),
                    priceEmoji,
                    Double.parseDouble(inventory.get(index).getPrice()) / 100), emojiDog),
                    String.format("SELL@%s", inventory.get(index).getId()));
        }
        return new InlineKeyboardMarkup()
                .setKeyboard(createButtons(result));
    }


}
