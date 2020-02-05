package bot.message.commands;

import api.market.Threads.TradeControllerSingleton;
import bot.userinterface.InventoryMenu;
import bot.userinterface.ItemOnSellMenu;
import bot.userinterface.MainMenu;
import models.apiModel.InventoryModel;
import models.apiModel.ItemFromInventoryModel;
import models.interfaces.EmojInterface;
import models.users.UserModel;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import subscribe.UserSubscribeControl;

import java.util.ArrayList;

public class BotCommands implements EmojInterface {
    private UserModel user;
    private CsGoMarket csGoMarket;

    public BotCommands(Update update) {
        user = UserSubscribeControl.getUserById(getChatId(update));
        csGoMarket = new CsGoMarket(user);
    }

    private String getChatId(Update update) {
        if(update.hasCallbackQuery()) {
            return String.valueOf(update.getCallbackQuery().getMessage().getChatId());
        } else {
            return String.valueOf(update.getMessage().getChatId());
        }
    }

    protected SendMessage getBalanceMessage() {
        return new SendMessage().enableMarkdown(true)
                .setChatId(user.getId())
                .setText(csGoMarket.getBalance());
    }

    protected SendMessage getTurnedOnMessage() {
        TradeControllerSingleton.switcher = true;
        return new SendMessage().enableMarkdown(true)
                .setChatId(user.getId())
                .setText(csGoMarket.setOnline());
    }

    protected SendMessage getTurnedOffMessage() {
        TradeControllerSingleton.switcher = false;
        return new SendMessage().enableMarkdown(true)
                .setChatId(user.getId())
                .setText(csGoMarket.setOffline());
    }

    protected SendMessage getSellItemMenu() {
        InventoryModel inventory = csGoMarket.getInventory();
        return new SendMessage()
                .setChatId(user.getId())
                .setText(EmojInterface.getTextWithEmojieSurround("CHOSE", emojiInventory))

                .setReplyMarkup(new InventoryMenu().getMenu(inventory));
    }

    protected SendMessage getMessageOfSell(String params) {
        return new SendMessage()
                .setChatId(user.getId())
                .setText(csGoMarket.sellItem(params));
    }

    protected SendMessage getClearListMessage() {
        return new SendMessage()
                .setChatId(user.getId())
                .setText(csGoMarket.clearSellingList());
    }

    protected SendMessage getInventoryMessage() {
        return new SendMessage().enableMarkdown(true)
                .setChatId(user.getId())
                .setText(csGoMarket.browseInventory());
    }

    protected SendMessage getListOfSells() {
        return new SendMessage()
                .setChatId(user.getId())
                .setText(EmojInterface.getTextWithEmojieSurround("ALL YOR SALES", emojiInventory))
                .setReplyMarkup(new ItemOnSellMenu().getMenu(csGoMarket.getIteemsOnSell()));
    }

    protected SendMessage writeToAdmin() {
        return new SendMessage()
                .setChatId(user.getId())
                .setText("You are not subscribe on this bot write to admin");
    }

    protected SendMessage getMainMenuKeyboard() {
        return new SendMessage()
                .setChatId(user.getId())
                .setText(EmojInterface.getTextWithEmojieSurround("WELCOME", emojiDog))
                .setReplyMarkup(new MainMenu().getMenu());
    }
}
