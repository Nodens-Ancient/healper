package bot.userinterface;

import bot.baseElements.BaseInterface;
import bot.elements.Button;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;

public class MainMenu extends BaseInterface {
    private static Button balance = new Button("BALANCE",
            "BALANCE", emojiMoney);
    private static Button turnOn = new Button("TURN ON",
            "TURN_ON", emojiStateOnline);
    private static Button turnOff = new Button("TURN OFF",
            "TURN_OFF", emojiStateOffline);
    private static Button sellItem = new Button("SELL ITEM",
            "SELL_ITEM", emojiSellAll);
    private static Button inventory = new Button("INVENTORY",
            "INVENTORY", emojiInventory);
    private static Button removeAll = new Button("CLEAR SELLING LIST",
            "CLEAR_SELLING_LIST", clearEmoji);

    public InlineKeyboardMarkup getMenu() {
        return new InlineKeyboardMarkup()
                .setKeyboard(createButtons(new Button[][]{
                        {balance},
                        {turnOn, turnOff},
                        {inventory},
                        {sellItem},
                        {removeAll}
                }));
    }


}
