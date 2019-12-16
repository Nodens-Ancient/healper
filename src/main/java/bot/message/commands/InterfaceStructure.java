package bot.message.commands;

import bot.message.ApiFunction;
import bot.userinterface.InventoryMenu;
import bot.userinterface.MainMenu;
import models.interfaces.EmojInterface;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;

class InterfaceStructure implements EmojInterface {
    private Long chatId;
    private String textOfMessage;
    InterfaceStructure(Update update) {
        chatId = getChatId(update);
    }

    private Long getChatId(Update update) {
        if(update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getChatId();
        } else {
            return update.getMessage().getChatId();
        }
    }

    public SendMessage getMainMenuKeyboard() {
        return new SendMessage()
                .setChatId(chatId)
                .setText(EmojInterface.getTextWithEmojieSurround("WELCOME", emojiDog))
                .setReplyMarkup(new MainMenu().getMenu());
    }

    public SendMessage getBalanceMessage() {
        return new SendMessage().enableMarkdown(true)
                .setChatId(chatId)
                .setText(ApiFunction.getBalance());
    }

    public SendMessage getTurnedOnMessage() {
        return new SendMessage().enableMarkdown(true)
                .setChatId(chatId)
                .setText(ApiFunction.setOnline());
    }

    public SendMessage getTurnedOffMessage() {
        return new SendMessage().enableMarkdown(true)
                .setChatId(chatId)
                .setText(ApiFunction.setOffline());
    }

    public SendMessage getSellItemMenu() {
        return new SendMessage()
                .setChatId(chatId)
                .setText(EmojInterface.getTextWithEmojieSurround("CHOSE", emojiInventory))
                .setReplyMarkup(new InventoryMenu().getMenu());
    }

    public SendMessage getMessageOfSell(String id) {
        return new SendMessage()
                .setChatId(chatId)
                .setText(ApiFunction.sellItem(id));
    }

    public SendMessage getClearListMessage() {
        return new SendMessage()
                .setChatId(chatId)
                .setText(ApiFunction.clearSellingList());
    }

    public SendMessage getInventoryMessage() {
        return new SendMessage().enableMarkdown(true)
                .setChatId(chatId)
                .setText(ApiFunction.browseInventory());
    }
}
