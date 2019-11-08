package bot;

import message.MessageFactory;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {
        try {
            execute(new MessageFactory(update.getMessage()).getMessageType());

        } catch (IOException | TelegramApiException e) {
            e.printStackTrace();
        }
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
