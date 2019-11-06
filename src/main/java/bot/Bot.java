package bot;

import message.MessageFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import parcel.Parcel;
import utils.PropertyController;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        try {
            try {
                sendMsg(update.getMessage().getChatId().toString(),
                        new Parcel().getParcelInfo(PropertyController.getValueByKey(message)));
            } catch (Exception e) {
                sendKeyboard(update.getMessage().getChatId().toString(), "|_-_|");
            }



        } catch (IOException | TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private synchronized void sendKeyboard(String chatId, String s) throws TelegramApiException, IOException {
        execute(new SendMessage()
                .enableMarkdown(true)
                .setChatId(chatId)
                .setText(s).setReplyMarkup(new Buttons().setParcelButtons()));
    }

    private synchronized void sendMsg(String chatId, String s) throws TelegramApiException {
        execute(new SendMessage()
                .enableMarkdown(true)
                .setChatId(chatId)
                .setText(s));

    }


    @Override
    public String getBotUsername() {
        return "Ofgkta_bot";
    }


    @Override
    public String getBotToken() {
        return "831206675:AAEhe93MAkyW3xw2TBKIE08zKIhb4wDeJII";
    }
}
