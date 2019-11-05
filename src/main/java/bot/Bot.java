package bot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import parcel.Parcel;
import utils.PropertyController;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        String message = update.getMessage().getText();
        try {
            sendMsg(update.getMessage().getChatId().toString(),
                    new Parcel().getParcelInfo(PropertyController.getValue(message)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private synchronized void sendMsg(String chatId, String s) {
        new Buttons().setButtons(new SendMessage()
                .enableMarkdown(true)
                .setChatId(chatId)
                .setText(s));
//        execute();

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
